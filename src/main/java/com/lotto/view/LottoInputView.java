package com.lotto.view;

import com.lotto.model.WinningLotto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LottoInputView {

    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_MISMATCH_PURCHASE_AMOUNT = "구입금액을 잘못 입력하였습니다.";
    private static final String INPUT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";

    public int inputPurhaseAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(INPUT_PURCHASE_AMOUNT);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException(INPUT_MISMATCH_PURCHASE_AMOUNT);
        }
    }

    public WinningLotto inputWinningNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(INPUT_WINNING_NUMBERS);
        String inputStringNumbers = scanner.nextLine();

        return WinningLotto.ofComma(inputStringNumbers);
    }
}
