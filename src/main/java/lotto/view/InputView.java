package lotto.view;

import util.NumberUtils;

import java.util.Scanner;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static int getIntValue(String message){
        System.out.println(message);
        String input = scanner.next();
        if(!NumberUtils.isIntValue(input)) {
            throw new IllegalArgumentException("입력 값이 숫자가 아닙니다.");
        }
        return Integer.parseInt(input);
    }
}