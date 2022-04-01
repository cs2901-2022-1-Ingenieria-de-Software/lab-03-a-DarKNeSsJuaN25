package lab.demand;

import java.util.List;

public class ManageDemand {

    private Tax tax;
    private double Quantity;
    private double Taxes;
    private List<Order> orders;
    public ManageDemand(Tax tax) {
        this.tax = tax;
        this.Quantity = 0;
        this.Taxes = 0;
    }

    public double calculateTotal(List<Order> orders){
        if(this.orders == null){
            this.orders = orders;
        }
        for(Order order:orders){
            order.setTax();
        }
        calculate_taxes();
        calculateQuantities();
        return this.Quantity * this.Taxes;
    }

    public void calculate_taxes(){
        double sum = 0.0;
        for(Order order:orders){
            double res = order.getTax();
            sum += res;
        }
        this.Taxes = sum;
    }
    public void calculateQuantities() {
        double quantities = 0.0;
        for (Order order : orders) {
            double temp = order.getQuantity();
            quantities += temp;
        }
        this.Quantity = quantities;
    }

    public double calculateTotalForWithAdditionalByCountry(List<Order> orders, double defaultAdditionalColombia, double defaultAdditionalPeru, double defaultAdditionalBrazil){
        // Calculate additionals by country
        if(this.orders == null){
            this.orders = orders;
        }
        for (Order order : orders) {
            if(order.getTax() == 0.0){
                order.setTax(defaultAdditionalColombia);
                this.Taxes += defaultAdditionalColombia;
            }
            else if(order.getTax() == 0.18){
                order.setTax(defaultAdditionalPeru);
                this.Taxes -= 0.18;
                this.Taxes += defaultAdditionalPeru;
            }
            else if(order.getTax() == 0.12){
                this.Taxes -=0.12;
                this.Taxes += defaultAdditionalBrazil;
                order.setTax(defaultAdditionalBrazil);
            }
        }
        return this.Quantity * this.Taxes;
    }

}
