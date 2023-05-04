package lotto;

import java.util.List;
import java.util.Map;

public class Customer {
    private Money money;
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

    public void buyLotto(LottoGenerator lottoGenerator) {
        int lottoCount = money.getMoney() / lottoGenerator.getPrice();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(lottoGenerator));
        }
    }

    public Map<KLottoRank, Integer> checkLottoWin(List<Integer> list, int bonusNumber) {
        rank = lottos.checkWin(list, bonusNumber);
        return rank;
    }
}
