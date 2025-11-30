package lotto.domain;

public class LottoGame {
    private final Lottos lottos;
    private final Money money;

    public LottoGame(Lottos lottos, Money money) {
        this.lottos = lottos;
        this.money = money;
    }
}
