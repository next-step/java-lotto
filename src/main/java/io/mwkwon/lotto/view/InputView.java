package io.mwkwon.lotto.view;

import io.mwkwon.lotto.domain.Lotto;
import io.mwkwon.lotto.domain.LottoPayment;
import io.mwkwon.lotto.domain.LottoStore;

import java.util.Scanner;

public class InputView {

    public static final String BUY_COUNT_MESSAGE = "개를 구매했습니다.";
    public static final String EXCEPTION_MESSAGE = "구입금액은 숫자만 입력 가능합니다.";
    public static final String REQUEST_PAYMENT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String REQUEST_WINNING_LOTTO_MESSAGE = "지난주 당첨 번호를 입력해주세요.";
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public LottoPayment requestInputPayment() {
        System.out.println(REQUEST_PAYMENT_MESSAGE);
        try {
            int lottoPayment = this.scanner.nextInt();
            return new LottoPayment(lottoPayment);
        } catch (Exception e) {
            System.out.println(EXCEPTION_MESSAGE);
            throw e;
        }
    }

    public void printBuyLottoCount(LottoPayment lottoPayment) {
        System.out.println(lottoPayment.toString() + BUY_COUNT_MESSAGE);
    }

    public void printBuyLottos(LottoStore lottoStore) {
        for (Lotto lotto : lottoStore.lottos()) {
            System.out.println(lotto);
        }
    }

    public Lotto requestWinningLottoNumbers() {
        System.out.println(REQUEST_WINNING_LOTTO_MESSAGE);
        String winningLottoNumber = this.scanner.nextLine();
        return new Lotto(winningLottoNumber);
    }

}
