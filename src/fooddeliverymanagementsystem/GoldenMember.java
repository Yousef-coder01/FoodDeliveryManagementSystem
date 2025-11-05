
package fooddeliverymanagementsystem;


public class GoldenMember extends Customer {
    private double monthlySubscriptionFee;
    private double discountRate;

    public GoldenMember(double monthlySubscriptionFee, double discountRate, int id, String name, String phoneNumber) {
        super(id, name, phoneNumber);
        this.monthlySubscriptionFee = monthlySubscriptionFee;
        this.discountRate = discountRate;
    }

    public double getMonthlySubscriptionFee() {
        return monthlySubscriptionFee;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setMonthlySubscriptionFee(double monthlySubscriptionFee) {
        this.monthlySubscriptionFee = monthlySubscriptionFee;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
    
    
    
    
}
