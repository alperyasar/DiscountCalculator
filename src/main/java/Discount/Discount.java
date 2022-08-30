package Discount;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Discount {
    /**
     * Calculate total price and discount as user membership
     * @param list list of user shopping items
     * @param user
     * @return  tatal price
     * @throws IOException
     */
    public double discount(List<Product> list,User user) throws IOException {
        return switch (user.discount()) {
            case 0 -> calc(0.7, list);
            case 1 -> calc(0.8, list);
            case 2 -> calc(0.9, list);
            case 3 -> calc(0.95, list);
            default -> calc(list);
        };
    }

    /**
     * calculate discount and total price using discount value
     * @param value discount value changing for user membership
     * @param list user shopping list
     * @return total price
     * @throws IOException
     */
    private static double calc(double value, List<Product> list) throws IOException {
        List<Product> Mainlist = readFile("data.txt");
        double total =0;
        double dis=0;

        for (Product element : list){
            for (Product element2 : Mainlist){
                if(element.type.contains("phone")){
                    if(element.type.equals(element2.type))
                        total += element2.getPrice();
                }
                else if(element.type.equals(element2.type))
                    dis += element2.getPrice();
            }
        }
        dis *= value;
        return total + dis;
    }

    /**
     * for just calculate if user does not have membership
     * @param list user shopping list
     * @return total price
     * @throws IOException
     */
    private static double calc(List<Product> list) throws IOException {
        List<Product> Mainlist = readFile("data.txt");
        double total =0;
        double dis=0;

        for (Product element : list){
            for (Product element2 : Mainlist){
                if(element.type.contains("phone")){
                    if(element.type.equals(element2.type))
                        total += element2.getPrice();
                }
                else if(element.type.equals(element2.type))
                    dis += element2.getPrice();
            }
        }

        int temp = (int)(dis / 200);
        dis = dis - (temp * 5);
        return total + dis;
    }

    /**
     * read price and item type from file
     * @param text filename
     * @return Product object list
     * @throws IOException
     */
    private static List<Product> readFile(String text) throws IOException {
        List<Product> list = new ArrayList<>();
        String[] info;
        String line;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(text);
        assert is != null;
        InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader inFile = new BufferedReader(streamReader);
        while((line = inFile.readLine()) != null)
        {
            info  = line.split(",");//; would be the delimiter
            list.add(new Product(info[0],Integer.parseInt(info[1])));
        }
        return list;
    }
}
