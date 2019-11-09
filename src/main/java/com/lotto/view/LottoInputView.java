package com.lotto.view;

import com.lotto.model.WinningLotto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LottoInputView {

    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_MISMATCH_PURCHASE_AMOUNT = "구입금액을 잘못 입력하였습니다.";
    private static final String INPUT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String COMMA_STRING = ",";
    private static final String EMPTY_STRING = "";

    private Scanner scanner = new Scanner(System.in);

    public int inputPurhaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException(INPUT_MISMATCH_PURCHASE_AMOUNT);
        }
    }

    public WinningLotto inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS);
        WinningLotto winningLotto = new WinningLotto();
        while (scanner.hasNext()) {
            String inputStringNumber = scanner.next();
            inputStringNumber = inputStringNumber.replaceAll(COMMA_STRING, EMPTY_STRING);
            winningLotto.inputWinningNumber(checkWinningNumber(inputStringNumber));
        }
        return winningLotto;
    }

    private int checkWinningNumber(String inputStringNumber) {
        try {
            return Integer.parseInt(inputStringNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WinningLotto.INPUT_WRONG_WINNING_NUMBER, e);
        }
    }
}
