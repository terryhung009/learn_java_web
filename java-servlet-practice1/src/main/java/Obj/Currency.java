package Obj;

public class Currency {
    double jpn = 4.4382;
    double usd = 0.0345;
    double twd = 1;
    double cny = 0.2300;
    private double amount;

    public Currency(double amount){
        this.amount=amount;
    }
    public double getJpn(){
        return this.amount * jpn;
    }
    public double getUsd(){
        return this.amount * usd;
    }
    public double getCny(){
        return this.amount * cny;
    }



}
