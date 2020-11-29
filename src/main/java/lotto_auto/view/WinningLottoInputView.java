package lotto_auto.view;

import lotto_auto.model.LottoNumber;
import lotto_auto.model.LottoNumbers;
import lotto_auto.model.WinningLotto;

import java.util.Scanner;

public class WinningLottoInputView {

    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String LOTTO_NUMBERS_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static WinningLotto enter() {
        LottoNumbers lottoNumbers = lottoNumbersEnter();
        LottoNumber bonusLottoNumber = bonusNumberEnter();
        return new WinningLotto(lottoNumbers, bonusLottoNumber);
    }

    private static LottoNumbers lottoNumbersEnter() {
        System.out.println(LOTTO_NUMBERS_INPUT_MESSAGE);
        String lottoNumberString = scanner.next();
        return new LottoNumbers(lottoNumberString);
    }

    private static LottoNumber bonusNumberEnter() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        int bonusNumber = scanner.nextInt();
        return new LottoNumber(bonusNumber);
    }
}
