package lab.util;

import java.util.List;
import java.util.ArrayList;

import lab.demand.Order;

public class TestUtil {

    public static List<Order> buildOrdersPeru() {
        List<Order> ordersPeru = new ArrayList<Order>();
        ordersPeru.add(new Order("PE", 10L));
        ordersPeru.add(new Order("PE", 10L));
        return ordersPeru;
    }

    public static List<Order> buildOrdersColombia() {
        List<Order> ordersPeru = new ArrayList<Order>();
        ordersPeru.add(new Order("CO", 10L));
        ordersPeru.add(new Order("CO", 10L));
        return ordersPeru;
    }
    public static List<Order> buildOrdersBrazil(){
        List<Order> ordersBrazil = new ArrayList<Order>();
        ordersBrazil.add(new Order("BR", 20L));
        ordersBrazil.add(new Order("BR", 20L));
        return ordersBrazil;
    }

    public static List<Order> buildOrdersRandom(){
        List<Order> random = new ArrayList<Order>();
        random.add(new Order("PE", 10L));
        random.add(new Order("PE", 10L));
        random.add(new Order("BR", 30L));
        random.add(new Order("CO", 40L));
        return random;
    }

}