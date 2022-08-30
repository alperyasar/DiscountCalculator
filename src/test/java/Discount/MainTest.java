package Discount;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Calendar;

public class MainTest {
    private static final double DELTA = 1e-15;
    Discount testDiscount = new Discount();
    @Test
    public void discount() throws IOException {
        List<Product> list =  new ArrayList<>();
        // phone 2500 hdd 100 * 0.7 = 2570
        list.add(new Product("phone"));
        list.add(new Product("hdd-1"));
        User user = new User("gold","Alper");

        double value = 2570.0;
        Assert.assertEquals(value,testDiscount.discount(list,user),DELTA);

    }

    @Test
    public void discount2() throws IOException {
        List<Product> list =  new ArrayList<>();
        list.add(new Product("phone"));
        list.add(new Product("hdd-1"));

        // 2500 + (2320 + 100 + 250) * 0.8) = 4636
        list.add(new Product("laptop"));
        list.add(new Product("ssd"));
        User user = new User("silver","Alper");
        double value = 4636.0;
        Assert.assertEquals(value,testDiscount.discount(list,user),DELTA);

    }
    @Test
    public void discount3() throws IOException {
        List<Product> list =  new ArrayList<>();
        list.add(new Product("phone"));
        list.add(new Product("hdd-1"));
        list.add(new Product("laptop"));
        list.add(new Product("ssd"));
        list.add(new Product("console-1"));
        list.add(new Product("phone-2"));
        list.add(new Product("shirt-2"));
        list.add(new Product("ssd-2"));
        // 2500 + 2850 + (2320 + 100 + 250 + 25 + 180+ 90) * 0.9 = 8018.5
        User user = new User("affiliate","Alper");
        double value = 8018.5;
        Assert.assertEquals(value,testDiscount.discount(list,user),DELTA);

    }
    @Test
    public void discount4() throws IOException {
        List<Product> list =  new ArrayList<>();
        list.add(new Product("phone"));
        list.add(new Product("hdd-1"));
        list.add(new Product("laptop"));
        list.add(new Product("ssd"));
        list.add(new Product("console-1"));
        list.add(new Product("phone-2"));
        list.add(new Product("shirt-2"));
        list.add(new Product("ssd-2"));
        // 2500 + 2850 + (2320 + 100 + 250 + 25 + 180+ 90) * 0.95 = 8166,75

        // creating a Calendar object
        Calendar c1 = Calendar.getInstance();
        // set Month
        // MONTH starts with 0 i.e. ( 0 - Jan)
        c1.set(Calendar.MONTH, 11);
        // set Date
        c1.set(Calendar.DATE, 05);
        // set Year
        c1.set(Calendar.YEAR, 2018);

        // creating a date object with specified time.
        Date dateOne = c1.getTime();
        User user = new User("no","Alper",dateOne);
        double value = 8166.75;
        Assert.assertEquals(value,testDiscount.discount(list,user),DELTA);
    }
    @Test
    public void discount5() throws IOException {
        List<Product> list =  new ArrayList<>();
        list.add(new Product("phone"));
        list.add(new Product("hdd-1"));
        list.add(new Product("laptop"));
        list.add(new Product("ssd"));
        list.add(new Product("console-1"));
        list.add(new Product("phone-2"));
        list.add(new Product("shirt-2"));
        list.add(new Product("ssd-2"));
        // 2500 + 2850 + (2320 + 100 + 250 + 25 + 180+ 90) her 200'de 5 dolar indirim = 5350

        // creating a Calendar object
        Calendar c1 = Calendar.getInstance();
        // set Month
        // MONTH starts with 0 i.e. ( 0 - Jan)
        c1.set(Calendar.MONTH, 11);
        // set Date
        c1.set(Calendar.DATE, 05);
        // set Year
        c1.set(Calendar.YEAR, 2021);

        // creating a date object with specified time.
        Date dateOne = c1.getTime();
        User user = new User("no","Alper",dateOne);
        double value = 8245.0;
        Assert.assertEquals(value,testDiscount.discount(list,user),DELTA);
    }
}