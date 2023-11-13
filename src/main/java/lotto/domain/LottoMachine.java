package lotto.domain;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1_000;
    private final Lottos lottos;


    public LottoMachine(Money money) {
        this.lottos = Lottos.of(calcPossibleLottoCount(money));
    }

    private int calcPossibleLottoCount(Money money) {
        return money.getMoney() / LOTTO_PRICE;
    }

    public Lottos getLottoTickets() {
        return this.lottos;
    }
}
