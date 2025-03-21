package stringcalcaulator;

import java.util.Scanner;

public class StringCalculatorMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("계산할 문자열을 입력하세요.");

        StringCalculator calc = new StringCalculator();
        int result = calc.calculate(scanner.nextLine());

        System.out.println(result);
    }

}
