package lotto;

import lotto.domain.Buy;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.RandomStrategy;
import lotto.util.RandomUtils;

/**
 * Created by seungwoo.song on 2022-10-06
 */
public class Application {

    private static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final int LOTTO_NUMBER_COUNT_LIMIT = 45;

    public static void main(String[] args) {
        LottoInputView inputView = new LottoInputView();

        Buy buy = new Buy(LOTTO_PRICE, inputView.read());

        LottoFactory lottoFactory = new LottoFactory(new RandomStrategy(() -> RandomUtils.getNumber(LOTTO_NUMBER_COUNT_LIMIT), LOTTO_NUMBER_COUNT));

        for (int i = 0; i < buy.getCount(); i++) {
            Lotto lotto = lottoFactory.produce();
            System.out.println("lotto = " + lotto);
        }
    }
}
