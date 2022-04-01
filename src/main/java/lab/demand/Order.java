package lab.demand;

public class Order {

    private String country;
    private Long quantity;
    private double tax;    
    public Order(String country, Long quantity) {
        this.country = country;
        this.quantity = quantity;
    }

    public Long getQuantity() {
        return quantity;
    }

    public String getCountry() {
        return country;
    }
    public double getTax(){
        return tax;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
    public void setTax(){
        if (country.equals("PE")) {
            this.tax = 0.18;
        } else if (country.equals("BR")) {
            this.tax = 0.12;
        } else {
            this.tax = 0.0;
        }
    }
            
}
