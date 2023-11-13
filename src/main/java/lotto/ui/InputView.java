package lotto.ui;

import lotto.exception.MisMatchNumberException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private static final String INPUT_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public int inputPrice() {
        System.out.println(INPUT_PURCHASE_PRICE);
        return inputNumber();
    }

    public String inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
        return scanner.next();
    }

    private int inputNumber() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException ex) {
            throw new MisMatchNumberException();
        }
    }

}
