package me.namuhuchutong.lotto.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int inputAmount() {
        printMessage("금액을 입력하세요.");
        return inputNumber();
    }

    public String[] inputManualLotto() {
        printMessage("수동으로 구매할 로또 수를 입력하세요.");
        int iterateCount = inputNumber();
        String[] manualLottos = new String[iterateCount];
        printMessage("로또 번호를 입력하세요. - " + iterateCount);
        for (int i = 0; i < iterateCount; i++) {
            manualLottos[i] = scanner.nextLine();
        }
        return manualLottos;
    }

    public String inputNumbers() {
        printMessage("당첨 번호를 입력하세요.");
        return scanner.nextLine();
    }

    public int inputBonusNumber() {
        printMessage("보너스 번호를 입력하세요.");
        return inputNumber();
    }

    private int inputNumber() {
        int number;
        try {
            number = scanner.nextInt();
            cleanBuffer();
        } catch (InputMismatchException exception) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
        return number;
    }

    private void cleanBuffer() {
        scanner.nextLine();
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
