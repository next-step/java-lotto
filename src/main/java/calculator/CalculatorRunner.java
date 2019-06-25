package calculator;

import java.util.Scanner;

public class CalculatorRunner {

    public static void main(String args[]) {
        System.out.println(ExpressionParser.parse(args[0]).sum());
    }
}
