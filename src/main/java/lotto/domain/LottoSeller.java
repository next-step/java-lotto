package lotto.domain;

public class LottoSeller {

    private static final String NOT_ENOUGH_MONEY = "돈이 모자랍니다";

    private static final int LOTTO_PRISE = 1000;

    public static Lottos buy(int money) {
        int buyCount = money / LOTTO_PRISE;
        if (buyCount < 1) {
            throw new IllegalArgumentException(NOT_ENOUGH_MONEY);
        }
        return LottoMachine.generate(buyCount);
    }

    public static MatchResult match(Lottos lottos, Lotto winningLotto) {
        return MatchResult.check(lottos, winningLotto);
    }

}
