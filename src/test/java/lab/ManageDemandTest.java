package lab;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import lab.demand.ManageDemand;
import lab.demand.Tax;
import lab.util.TestUtil;
import lab.demand.Order;

import java.util.List;
import java.util.Map;

@Test
public class ManageDemandTest {

    private Tax tax;

    private ManageDemand demand;

    @BeforeClass
    public void setup() {
        tax = new Tax();
        demand =  new ManageDemand(tax);
    }
    //Calculate_Total Test
    public void test_AllOrdersFromPeru() {
        List<Order> ordersFromPeru = TestUtil.buildOrdersPeru();
        double result = demand.calculateTotal(ordersFromPeru);
        Assert.assertEquals(Math.round(result), 7.0);
    }
    public void test_AllOrdersFromBrazil(){
        List<Order> ordersFromBrazil = TestUtil.buildOrdersBrazil();
        double result = demand.calculateTotal(ordersFromBrazil);
        Assert.assertEquals(Math.round(result),10.0);
    }
    public void test_AllOrdersFromColombia(){
        List<Order> ordersFromColomiba = TestUtil.buildOrdersColombia();
        double result = demand.calculateTotal(ordersFromColomiba);
        Assert.assertEquals(Math.round(result),0.0);
    }
    //2do
    public void test_AditionalCountry(){
        List<Order> orders = TestUtil.buildOrdersRandom();
        double result = demand.calculateTotalForWithAdditionalByCountry(orders, 0.1, 0.2,0.3);
        Assert.assertEquals(Math.round(result), 72.0);
    }
    public void test_getOrder(){
        List<Order> orders = TestUtil.buildOrdersPeru();
        double result = demand.calculateTotal(orders)/demand.getQuantity();
        Assert.assertEquals(Math.round(result), 0.0);
    }

}
