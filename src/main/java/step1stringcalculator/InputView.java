package step1stringcalculator;

import java.util.Scanner;

public class InputView {
    public static String insertCalculatorString(Scanner scanner) {
        System.out.println("계산할 문자열을 입력하세요");
        return scanner.next();
    }
}
