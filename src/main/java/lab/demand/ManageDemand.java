package lab.demand;

import java.util.List;

public class ManageDemand {

    private Tax tax;
    private double Quantity;
    private double Taxes;
    public ManageDemand(Tax tax) {
        this.tax = tax;
    }

    public double calculateTotal(List<Order> orders){
       
        return this.Quantity * this.Taxes;
    }

    public void calculate_taxes(List <Order> orders){
        double sum = 0.0;
        for(Order order:orders){
            double res = order.getTax();
            sum += res;
        }
        this.Taxes = sum;
    }
    public void calculateQuantities(List <Order> orders) {
        double quantities = 0.0;
        for (Order order : orders) {
            double temp = order.getQuantity();
            quantities += temp;
        }
        this.Quantity = quantities;
    }

    public double calculateTotalForWithAdditionalByCountry(List<Order> orders, double defaultAdditionalColombia, double defaultAdditionalPeru, double defaultAdditionalBrazil){
        // Calculate additionals by country
        double taxes = 0.0;
        for (Order order : orders) {
            String currCountry = order.getCountry();
            if (currCountry.equals("PE")) {
                taxes += defaultAdditionalPeru;
            } else if (currCountry.equals("BR")) {
                taxes += defaultAdditionalBrazil;
            } else {
                taxes += defaultAdditionalColombia;
            }
        }

        // Calculate Total
        double quantities = 0.0;
        for (Order order : orders) {
            double temp = order.getQuantity();
            quantities += temp;
        }

        return quantities * taxes;
    }

}
