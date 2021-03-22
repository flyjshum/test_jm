package ru.jm;

import ru.jm.exceptions.InputStringFormatException;
import ru.jm.exceptions.NotInIntervalException;
import java.util.regex.Pattern;

import static ru.jm.RegExString.*;

public class Calculator {

    private String a, b;
    private String operand;
    private ArithmeticOperations calc;

    public Calculator(String input) throws InputStringFormatException, NotInIntervalException {
        RegExString regExString = null;

        //Проверка на корректность по шаблону "a <операнд> b" иначе исклюение
        boolean isCorrectInputString = false;
        for (RegExString item : values())
            if (Pattern.matches(item.getRegEx(), input)) {
                String[] arrInput = input.split(" ");
                this.a = arrInput[0];
                this.b = arrInput[2];
                this.operand = arrInput[1];
                isCorrectInputString = true;
                regExString = item;
                break;
            }
        if (!isCorrectInputString)
            throw new InputStringFormatException("Not correct input string");


        //Проверка на вхождение в интервалы от 1 до 10 (от I до X), иначе исключение
        switch (regExString) {
            case ARABIC: {
                if (Integer.parseInt(a) >= 1 && Integer.parseInt(a) <= 10 &&
                        Integer.parseInt(b) >= 1 && Integer.parseInt(b) <= 10)
                    calc = new ArabicCalc();
                else throw new NotInIntervalException("a or b not in interval from 1 to 10");
                break;
            }

            case ROME: {
                try {
                    if (RomeDigit.valueOf(a) instanceof RomeDigit && RomeDigit.valueOf(b) instanceof RomeDigit)
                        if (RomeDigit.valueOf(a).ordinal() >= 0 && RomeDigit.valueOf(a).ordinal() <= 9 &&
                                RomeDigit.valueOf(b).ordinal() >= 0 && RomeDigit.valueOf(b).ordinal() <= 9)
                            calc = new RomeCalc();
                        else throw new NotInIntervalException("a or b not in interval from I to X");
                    else throw new NotInIntervalException("a or b not in interval from I to X");
                    break;
                } catch (IllegalArgumentException e) {
                    throw new NotInIntervalException("a or b not in interval from I to X");
                }
            }
        }
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String getOperand() {
        return operand;
    }

    public ArithmeticOperations getCalc() {
        return calc;
    }
}