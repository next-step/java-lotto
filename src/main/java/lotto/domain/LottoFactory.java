package lotto.domain;

// NOTE: NumberLottoFactory 와 StringLottoFactory 의 Facade
public class LottoFactory {
    private LottoFactory() {
    }

    public static LottoFactory getInstance() {
        return SingletonHelper.instance;
    }

    public Lotto createLotto(int[] lottoNos) {
        return new Lotto();
    }

    public Lotto createLotto(String lottoStr) {
        return new Lotto();
    }

    private static class SingletonHelper {
        private static final LottoFactory instance = new LottoFactory();
    }
}
