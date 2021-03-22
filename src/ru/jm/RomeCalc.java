package ru.jm;

public class RomeCalc implements ArithmeticOperations {

    @Override
    public String iPlus(String a, String b) {
        return strToRome(String.valueOf(Integer.parseInt(romeToStr(a)) + Integer.parseInt(romeToStr(b))));
    }

    @Override
    public String iMinus(String a, String b) {
        return strToRome(String.valueOf(Integer.parseInt(romeToStr(a)) - Integer.parseInt(romeToStr(b))));

    }

    @Override
    public String iMultiplication(String a, String b) {
        return strToRome(String.valueOf(Integer.parseInt(romeToStr(a)) * Integer.parseInt(romeToStr(b))));

    }

    @Override
    public String iDivision(String a, String b) {
        return strToRome(String.valueOf(Integer.parseInt(romeToStr(a)) / Integer.parseInt(romeToStr(b))));

    }

    private String romeToStr(String str) {
        return RomeDigit.valueOf(str).getTitle();
    }

    private String strToRome(String str) {
        String result = "";
        int i=RomeDigit.contains(str);
        if (i!=-1)
            result=RomeDigit.values()[i].name();
        else {
            int ones=Integer.parseInt(str)%10;
            int tens=(Integer.parseInt(str))-ones;
            result=RomeDigit.values()[RomeDigit.contains(String.valueOf(tens))].name()
                    +RomeDigit.values()[RomeDigit.contains(String.valueOf(ones))].name();
            }
        return result;
    }
}

