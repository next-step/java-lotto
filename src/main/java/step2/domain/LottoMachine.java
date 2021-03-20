package step2.domain;

import java.util.List;
import java.util.Map;

public class LottoMachine {

    private Lottos lottos;
    private LottoStatistics lottoStatistics;
    private Money money;

    //테스트를 위한 생성자
    public LottoMachine() {
        this.lottos = new Lottos();
    }

    //테스트를 위한 생성자
    public LottoMachine(Lottos lottos) {
        this.lottos = lottos;
    }

    public Lottos createLotto(int money, List<String> manualLottoList) {
        this.money = new Money(money);
        if (manualLottoList.isEmpty()) {
            return lottos.createLottoList(getLottoCount(this.money));
        }
        Money autoLottoMoney = new Money(money, manualLottoList.size());
        Lottos autoLottos = lottos.createLottoList(getLottoCount(autoLottoMoney));
        Lottos manualLottos = new Lottos(manualLottoList);
        this.lottos = new Lottos(manualLottos, autoLottos);
        return this.lottos;
    }

    private int getLottoCount(Money money) {
        return money.divideMoneyByPrice();
    }

    public List<Integer> getRankOfLottos(Lotto winNumber) {
        return lottos.getRankOfLotto(winNumber);
    }

    public List<Boolean> getMatchOfBonus(LottoNumber lottoNumber) {
        return lottos.matchOfBonus(lottoNumber);
    }

    public Map<Integer, Long> statistics(Lotto winNumbers, LottoNumber bonusNumber) {
        List<Integer> rankOfLottos = getRankOfLottos(winNumbers);
        lottoStatistics = new LottoStatistics(rankOfLottos);
        return lottoStatistics.statistics(getMatchOfBonus(bonusNumber));
    }

    public double calculateProfitRate() {
        return lottoStatistics.calculateProfitRate(money);
    }
}
