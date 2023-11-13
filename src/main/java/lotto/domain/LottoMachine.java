package lotto.domain;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1_000;
    private final Money money;
    private final Lottos lottos;


    public LottoMachine(Money money) {
        this.money = money;
        this.lottos = Lottos.of(calcPossibleLottoCount());
    }

    private int calcPossibleLottoCount() {
        return this.money.getMoney() / LOTTO_PRICE;
    }

    public Lottos getLottoTickets() {
        return this.lottos;
    }
}
