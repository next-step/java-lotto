package lotto.domain;

public class LottoSeller {

    private static final String NOT_ENOUGH_MONEY = "돈이 모자랍니다";
    private static final int LOTTO_PRISE = 1000;
    private static final int MIN_BUY_COUNT = 1;

    public static Lottos buy(Money money) {
        int buyCount = money.buyCount(LOTTO_PRISE);
        if (buyCount < MIN_BUY_COUNT) {
            throw new IllegalArgumentException(NOT_ENOUGH_MONEY);
        }
        return LottoMachine.generate(buyCount);
    }

    public static MatchResult match(Lottos lottos, WinningLotto winningLotto) {
        return MatchResult.check(lottos, winningLotto);
    }

}
