package stringpluscalculator;

import java.util.Scanner;

public class StringPlusCalculatorRun {

    public static void main(String[] args) {

        System.out.println("수식을 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        String formula = scanner.next();

        StringPlusCalculator stringPlusCalculator = new StringPlusCalculator(formula);
        System.out.println("결과 : " + stringPlusCalculator.calculate());
    }
}
