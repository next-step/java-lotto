package stringcalculator;

import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String calculatorString = insertMathExpression(scanner);
        Calculator calculator = new Calculator(calculatorString);
        calculator.checkMathExpression();
        int resultNumber = calculator.calculate();
        System.out.println("결과 값 : " + resultNumber);
    }

    public static String insertMathExpression(Scanner scanner) {
        System.out.println("계산할 문자열을 입력하세요");
        return scanner.nextLine();
    }

}
