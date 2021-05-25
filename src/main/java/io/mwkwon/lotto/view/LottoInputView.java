package io.mwkwon.lotto.view;

import io.mwkwon.lotto.domain.Lotto;
import io.mwkwon.lotto.domain.LottoNumber;
import io.mwkwon.lotto.domain.LottoPayment;
import io.mwkwon.lotto.interfaces.DataGenerator;

import java.util.Scanner;

public class LottoInputView implements DataGenerator {
    private static final String REQUEST_PAYMENT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_LOTTO_MESSAGE = "지난주 당첨 번호를 입력해주세요.";
    private static final String RETRY_MESSAGE = "\n다시 입력 해주세요.";
    private static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "지난주 당첨 번호 입력값과 동일한 값이 입력되었습니다.";

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public LottoPayment requestInputPayment() {
        String value = this.requestInput(REQUEST_PAYMENT_MESSAGE);
        LottoPayment lottoPayment = null;
        try {
            lottoPayment = LottoPayment.create(value);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + RETRY_MESSAGE);
            requestInputPayment();
        }
        return lottoPayment;
    }

    @Override
    public Lotto requestWinningLottoNumbers() {
        String strLottoNumbers = this.requestInput(REQUEST_WINNING_LOTTO_MESSAGE);
        Lotto lotto = null;
        try {
            lotto = Lotto.create(strLottoNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + RETRY_MESSAGE);
            requestWinningLottoNumbers();
        }
        return lotto;
    }

    @Override
    public LottoNumber requestBonusBallNumber(Lotto winningLotto) {
        String strNumber = this.requestInput("보너스 볼을 입력해 주세요.");
        LottoNumber lottoNumber = null;
        try {
            lottoNumber = LottoNumber.create(strNumber);
            this.checkDuplicateLottoNumber(lottoNumber, winningLotto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + RETRY_MESSAGE);
            requestBonusBallNumber(winningLotto);
        }
        return lottoNumber;
    }

    private void checkDuplicateLottoNumber(LottoNumber lottoNumber, Lotto winningLotto) {
        if (winningLotto.isContains(lottoNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
        }
    }

    private String requestInput(String message) {
        System.out.println(message);
        return this.scanner.nextLine();
    }
}
