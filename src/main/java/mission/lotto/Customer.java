package mission.lotto;

import java.util.List;
import java.util.Map;

public class Customer {
    private Money money;
    private Lottos lottos;
    private RankLottos rankLottos;

    public Customer(int money){
        this.money = new Money(money);
        this.lottos = new Lottos();
    }

    public int getMoney(){
        return this.money.getMoney();
    }

    public List<Lotto> getLottos() {
        return this.lottos.getLottos();
    }

    public Map<KLottoRank, Integer> getRankLottos(){
        return this.rankLottos.getRank();
    }

    public void buyLotto(LottoGenerator lottoGenerator) {
        for(int i=0; i<money.getMoney()/lottoGenerator.getPrice(); i++) {
            lottos.add(new Lotto(lottoGenerator));
        }
    }

    public void checkLottoWin(List<Integer> list) {
        rankLottos = lottos.checkWin(list);
    }


}
