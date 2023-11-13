package me.namuhuchutong.lotto.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public String InputNumbers() {
        printMessage("당첨 번호를 입력하세요.");
        return scanner.nextLine();
    }

    public int inputAmount() {
        printMessage("금액을 입력하세요.");
        int amount = 0;
        try {
            amount = scanner.nextInt();
            cleanBuffer();
        } catch (InputMismatchException exception) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
        return amount;
    }

    private void cleanBuffer() {
        scanner.nextLine();
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
