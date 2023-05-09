package lotto;

import java.util.List;
import java.util.Map;

public class Customer {
    private Money money;
    private Money lottoMoney;
    private Lottos lottos;
    private Map<KLottoRank, Integer> rank;

    public Customer(int money) {
        this.money = new Money(money);
        this.lottos = new Lottos();
    }

    public int getMoney() {
        return this.money.getMoney();
    }

    public List<Lotto> getLottos() {
        return this.lottos.getLottos();
    }

    public void buyLotto() {

        if (money.getMoney() < Lotto.LOTTO_PRICE) {
            throw new IllegalStateException("로또 살 돈이 부족합니다.");
        }

        int lottoCount = money.getMoney() / Lotto.LOTTO_PRICE;
        lottoMoney = new Money(lottoCount * Lotto.LOTTO_PRICE);
        money = money.spend(lottoCount * Lotto.LOTTO_PRICE);
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto());
        }
    }

    public Map<KLottoRank, Integer> checkLottoWin(WinNumber winNumber) {
        rank = lottos.checkWin(winNumber);
        return rank;
    }

    public int getLottoMoney() {
        return this.lottoMoney.getMoney();
    }
}
