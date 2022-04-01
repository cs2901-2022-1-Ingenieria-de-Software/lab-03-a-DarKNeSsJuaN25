package lab.demand;

import java.util.List;

public class ManageDemand {

    private Tax tax;
    private double Quantity;
    private double Taxes;
    public ManageDemand(Tax tax) {
        this.tax = tax;
        this.Quantity = 0;
        this.Taxes = 0;
    }
    public double getQuantity(){
        return this.Quantity;
    }
    public double getTax(){
        return this.Taxes;
    }

    public double calculateTotal(List<Order> orders){
        double sum1=0.0,sum2=0.0;
        for(Order order:orders){
            order.setTax();
            sum1 += order.getTax();
            sum2 += order.getQuantity();
        }
        this.Quantity = sum2;
        this.Taxes = sum1;
        return this.Quantity * this.Taxes;
    }

    public double calculateTotalForWithAdditionalByCountry(List<Order> orders, double defaultAdditionalColombia, double defaultAdditionalPeru, double defaultAdditionalBrazil){
        // Calculate additionals by country
        boolean verify = false;
        if(this.Taxes == 0){
            verify = true;
        }
        for (Order order : orders) {
            if(verify){
                order.setTax(defaultAdditionalColombia,defaultAdditionalPeru,defaultAdditionalBrazil);
                this.Taxes += order.getTax();
                this.Quantity += order.getQuantity();
            }
            else if(order.getTax() == 0.0){
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
