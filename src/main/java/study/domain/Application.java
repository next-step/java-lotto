package study.domain;

import study.domain.util.FormulaParser;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        final String input = getString();

        final int result = calcResult(input);

        System.out.println("계산 결과 = " + result);
    }

    /**
     * 계산기를 이용하여 계산을 수행한다.
     * @param input
     * @return 계산 결과
     */
    private static int calcResult(final String input) {
        final Calculator calculator = new Calculator(new FormulaParser(input));
        return calculator.calculate();
    }

    /**
     * 사용자로부터 문자열을 입력받는다.
     * @return 사용자가 입력한 문자열
     */
    private static String getString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
