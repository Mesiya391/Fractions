package com.company;

import java.util.logging.Logger;

public class Fraction implements Comparable<Fraction>{

private int numerator;
private int denominator;

        Fraction(){}

        Fraction(int n,int d) {
            this.numerator = n;
            this.denominator = d;
        }

    int getNumerator() {
        return numerator;
    }

    void setNumerator(int numerator) {

        this.numerator = numerator;

    }


    int getDenominator() {
        return denominator;
    }

    void setDenominator(int denominator)  {

        this.denominator = denominator;
    }

    private static int gcd(Fraction f1, Fraction f2){
        int a = f1.denominator;
        int b = f2.denominator;
        int t;
        while(b!=0){
            t=b;
            b=a%b;
            a=t;
        }
        return a;
    }

    private static int gcd(int n, int d){
        int t;
        while(d!=0){
            t=d;
            d=n%d;
            n=t;
        }
        return n;
    }

    private static int nww(Fraction f1, Fraction f2){
        return f1.denominator/ gcd(f1, f2)*f2.denominator;
    }

    public Fraction adding(Fraction f2) {
        int n = (numerator *f2.denominator)+(f2.numerator*denominator);
        int d = denominator*f2.denominator;
        return new Fraction(n, d);
    }

    void reduce(){
        int t = gcd(this.numerator, this.denominator);
        this.setNumerator(this.numerator/t);
        this.setDenominator(this.denominator/t);
    }

    public Fraction subtraction(Fraction f2){
        int n = (numerator*f2.denominator) - (f2.numerator*denominator);
        int d = denominator*f2.denominator;
        Fraction result = new Fraction(n, d);
        return result;
    }

    public Fraction multiplication(Fraction f2){
        int n = numerator*f2.numerator;
        int d = denominator*f2.denominator;
        return new Fraction(n, d);
    }

    public Fraction division(Fraction f2){

        int n = numerator*f2.denominator;
        int d = denominator*f2.numerator;
        return  new Fraction(n, d);
    }

    float toDecimal() throws IncorrectDenominator {
        if (denominator == 0) {
            throw new IncorrectDenominator("0 cannot be used as denominator");
        } else {
            float result = (float) numerator / (float) denominator;
            return result;
        }
    }

    void exponentiation(double power){
        double n = Math.pow(this.numerator, power);
        double d = Math.pow(this.denominator, power);
        this.setNumerator((int)n);
        this.setDenominator((int)d);
    }

    void root(double power){
        double n = Math.pow(this.numerator, 1/power);
        double d = Math.pow(this.denominator, 1/power);
        this.setNumerator((int)n);
        this.setDenominator((int)d);
    }

    @Override
    public int compareTo(Fraction f) {
        int f1 = numerator*f.denominator;
        int f2 = f.numerator*denominator;
        if(f1<f2){
            return -1;
        } else if(f1>f2){
            return 1;
        } else {
            return 0;
        }
    }

    public boolean equals(Object obj){
        Fraction f2 = (Fraction) obj;
        boolean status = false;
        if((this.numerator==f2.numerator)
                && (this.denominator == f2.denominator )){
            status = true;
        }
        return status;
    }


    public String toString(){
        return this.numerator+"/"+this.denominator;
    }

}



