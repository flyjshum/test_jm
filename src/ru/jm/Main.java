package ru.jm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import ru.jm.exceptions.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //читаем строку
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Calculator start. Input string format a + b, a - b, a * b, a / b, (a и b - arabic or rome digit from 1(I) to 10(X)).\n" +
                "Print exit for shutdown.");
        //работаем до тех пор пока не наберем exit либо не выбросим исключение
        while (true) {
            String input = reader.readLine();
            if (input.equals("exit")) break;
            try {
                Calculator calc = new Calculator(input);
                ArithmeticOperations arithmeticOperations=calc.getCalc();
                if (calc != null)
                    switch (calc.getOperand()) {
                        case "+":
                            System.out.println(arithmeticOperations.iPlus(calc.getA(), calc.getB()));
                            break;
                        case "-":
                            System.out.println(arithmeticOperations.iMinus(calc.getA(), calc.getB()));
                            break;
                        case "*":
                            System.out.println(arithmeticOperations.iMultiplication(calc.getA(), calc.getB()));
                            break;
                        case "/":
                            System.out.println(arithmeticOperations.iDivision(calc.getA(), calc.getB()));
                            break;
                        default:
                            throw new UnsupportedOperatorException("Unsuporrted operand");
                    }
            } catch (NotInIntervalException | InputStringFormatException | UnsupportedOperatorException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
}
