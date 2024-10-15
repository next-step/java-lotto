package view;

import domain.Tokens;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static Tokens getTokens() {
        System.out.println("계산하고 싶은 식을 입력해주세요. 숫자와 연산자 사이는 공백으로 구분해주세요. (예: 1 + 2 * 3 / 4 - 5)");
        String expression = SCANNER.nextLine().trim();
        return new Tokens(expression);
    }
}
