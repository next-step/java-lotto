package lotto.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    final static String DELIMITER = ",";

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int getBuyLottoAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return getIntInput();
    }

    public String getLastWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return getStringInput();
    }


    private String getStringInput() {
        String winningNumbers;
        try {
            scanner.nextLine();
            winningNumbers = scanner.nextLine();
        } catch (Exception e) {
            throw new IllegalArgumentException("input valid number");
        }
        if (winningNumbers.split(DELIMITER).length != 6) {
            throw new IllegalArgumentException("input 6 last winning numbers.");
        }
        return winningNumbers;
    }

    private int getIntInput() {
        int amount;
        try {
            amount = scanner.nextInt();
        } catch (InputMismatchException ime) {
            throw new IllegalArgumentException("input valid number");
        }
        return amount;
    }


}
