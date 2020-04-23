package lotto.domain;

public class LottoSeller {

    private static final String NOT_ENOUGH_MONEY = "돈이 모자랍니다";
    private static final int LOTTO_PRISE = 1000;
    private static final int MIN_BUY_COUNT = 1;

    public static Lottos buy(int money) {
        int buyCount = money / LOTTO_PRISE;
        if (buyCount < MIN_BUY_COUNT) {
            throw new IllegalArgumentException(NOT_ENOUGH_MONEY);
        }
        return LottoMachine.generate(buyCount);
    }

    public static MatchResult match(Lottos lottos, Lotto winningLotto, LottoNumber bonusNumber) {
        return MatchResult.check(lottos, winningLotto, bonusNumber);
    }

}
