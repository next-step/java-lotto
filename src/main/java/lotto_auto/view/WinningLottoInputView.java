package lotto_auto.view;

import lotto_auto.model.LottoNumbers;

import java.util.Scanner;


public class WinningLottoInputView {

    private static final String MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    public static LottoNumbers enter() {
        System.out.println(MESSAGE);
        Scanner scanner = new Scanner(System.in);
        String lottoNumberString = scanner.next();
        return new LottoNumbers(lottoNumberString);
    }
}
