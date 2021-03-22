package ru.jm;

public class ArabicCalc implements ArithmeticOperations {
    @Override
    public String iPlus(String a, String b) {
        return String.valueOf(Integer.parseInt(a)+Integer.parseInt(b));
    }

    @Override
    public String iMinus(String a, String b) {
        return String.valueOf(Integer.parseInt(a)-Integer.parseInt(b));
    }

    @Override
    public String iMultiplication(String a, String b) {
        return String.valueOf(Integer.parseInt(a)*Integer.parseInt(b));
    }

    @Override
    public String iDivision(String a, String b) {
        return String.valueOf(Integer.parseInt(a)/Integer.parseInt(b));
    }
}
