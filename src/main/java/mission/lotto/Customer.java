package mission.lotto;

import java.util.List;
import java.util.Map;

public class Customer {
    private Money money;
    private Lottos lottos;
    private RankLotto rankLotto;

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

    private Map<KLottoRank, Integer> getRankLottos() {
        return this.rankLotto.getRank();
    }

    public void buyLotto(LottoGenerator lottoGenerator) {
        for (int i = 0; i < money.getMoney() / lottoGenerator.getPrice(); i++) {
            lottos.add(new Lotto(lottoGenerator));
        }
    }

    public Map<KLottoRank, Integer> checkLottoWin(List<Integer> list) {
        rankLotto = lottos.checkWin(list);
        return getRankLottos();
    }
}
