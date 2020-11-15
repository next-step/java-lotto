package lotto.controller.strategy;

import lotto.domain.Lotto;
import lotto.domain.LottoNo;
import lotto.utils.Shuffler;

import java.util.List;

/**
 * FIXME: 이런건 테스트를 어떻게 해야할지 감이 안잡힌다.
 * 도와주세요!!
 */
public class RandomStrategy implements GenerateStrategy {

    Shuffler shuffler;

    private RandomStrategy() {
        shuffler = new Shuffler(LottoNo.MAX, LottoNo.MIN);
    }

    public static RandomStrategy getInstance() {
        return SingletonHelper.instance;
    }

    @Override
    public Lotto generateLotto() {
        List<Integer> lottoNos = shuffler.getIntegers(Lotto.SIZE);
        return new Lotto(lottoNos);
    }

    private static class SingletonHelper {
        private static final RandomStrategy instance = new RandomStrategy();
    }
}
