package com.company;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;


public class ClassTest
{
    private Fraction f1 = new Fraction();
    private Fraction f2 = new Fraction();

    @Test
    public void testAdding (){
    f1.setNumerator(3);
    f1.setDenominator(5);
    f2.setNumerator(4);
    f2.setDenominator(9);
    Fraction f3 = f1.adding(f2);
    Fraction f4 = new Fraction(47, 45);
    Assert.assertEquals(f4, f3);
    }
   @Test
    public void testSubstraction(){
        f1.setNumerator(9);
        f1.setDenominator(2);
        f2.setNumerator(7);
        f2.setDenominator(5);
        Fraction c = f1.subtraction(f2);
        Fraction d = new Fraction(31, 10);
        Assert.assertEquals(d, c);
    }
    @Test
    public void testMultiplication(){
        f1.setNumerator(13);
        f1.setDenominator(2);
        f2.setNumerator(3);
        f2.setDenominator(7);
        Fraction c = f1.multiplication(f2);
        Fraction d = new Fraction(39, 14);
        Assert.assertEquals(d, c);
    }
    @Test
    public void testDivision(){
        f1.setNumerator(15);
        f1.setDenominator(7);
        f2.setNumerator(31);
        f2.setDenominator(4);
        Fraction c = f1.division(f2);
        Fraction d = new Fraction(60, 217);
        Assert.assertEquals(d, c);
    }
    @Test
    public void testReduction(){
        f1.setNumerator(28);
        f1.setDenominator(7);
        f1.reduce();
        Fraction f2 = new Fraction(4, 1);
        Assert.assertEquals(f2, f1);
    }
    @Test
    public void testExpotentation(){
        f1.setNumerator(3);
        f1.setDenominator(7);
        f1.exponentiation(2);
        Fraction f2 = new Fraction(9, 49);
        Assert.assertEquals(f2, f1);
    }
    @Test
    public void testRoot(){
        f1.setNumerator(9);
        f1.setDenominator(16);
        f1.root(2);
        Fraction f2 = new Fraction(3, 4);
        Assert.assertEquals(f2, f1);
    }
    @Test
    public void testToString(){
        f1.setNumerator(3);
        f1.setDenominator(4);
        Assert.assertEquals("3/4", f1.toString());
    }
    @Test
    public void testToDecimal() throws IncorrectDenominator {
        double delta  = 1e-15;
        f1.setNumerator(3);
        f1.setDenominator(4);
        Assert.assertEquals(0.75, f1.toDecimal(), delta);
    }
    @Test
    public void testCompareTo(){
        f1.setNumerator(3);
        f1.setDenominator(5);
        f2.setNumerator(4);
        f2.setDenominator(6);
        Assert.assertEquals(0, f1.compareTo(new Fraction(3, 5)));
        Assert.assertTrue(f1.compareTo(f2)<0);
        Assert.assertTrue(f2.compareTo(f1)>0);
    }


  //  @Rule
   // public ExpectedException thrown = ExpectedException.none();
    @Test(expected = IncorrectDenominator.class)
    public void throwsIncorrectDenominator() throws IncorrectDenominator {
        Fraction f1 =new Fraction( 3, 0);
        f1.toDecimal();
    }


}
