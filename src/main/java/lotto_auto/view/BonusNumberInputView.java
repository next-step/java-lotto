package lotto_auto.view;

import lotto_auto.model.LottoNumber;

import java.util.Scanner;

public class BonusNumberInputView {
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 볼을 입력해 주세요.";

    public static LottoNumber enter() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        int bonusNumber = scanner.nextInt();
        return new LottoNumber(bonusNumber);
    }
}
