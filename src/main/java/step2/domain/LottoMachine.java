package step2.domain;

import java.util.List;
import java.util.Map;

public class LottoMachine {

    private static final int WIN_NUMBER_LENGTH = 6;
    private final Lottos lottos;
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
        if (manualLottoList.size() < 1) {
            return lottos.createLottoList(getLottoCount(this.money));
        }
        Money autoLottoMoney = new Money(money, manualLottoList.size());
        Lottos autoLottos = lottos.createLottoList(getLottoCount(autoLottoMoney));
        Lottos manualLottos = new Lottos(manualLottoList);
        return new Lottos(manualLottos, autoLottos);
    }

    private int getLottoCount(Money money) {
        return money.divideMoneyByPrice();
    }

    public List<Integer> getRankOfLottos(List<LottoNumber> winNumber) {
        return lottos.getRankOfLotto(winNumber);
    }

    private void valid(List<LottoNumber> stringNumbers) {
        if (money == null) {
            throw new RuntimeException("로또를 먼저 생성해 주세요!");
        }
        if (stringNumbers.size() != WIN_NUMBER_LENGTH) {
            throw new IllegalArgumentException("당첨번호가 6개가 아닙니다.");
        }
    }

    public List<Boolean> getMatchOfBonus(LottoNumber lottoNumber) {
        return lottos.matchOfBonus(lottoNumber);
    }

    public Map<Integer, Long> statistics(List<LottoNumber> winNumbers, LottoNumber bonusNumber) {
        valid(winNumbers);
        List<Integer> rankOfLottos = getRankOfLottos(winNumbers);
        lottoStatistics = new LottoStatistics(rankOfLottos);
        return lottoStatistics.statistics(getMatchOfBonus(bonusNumber));
    }

    public double calculateProfitRate() {
        return lottoStatistics.calculateProfitRate(money);
    }
}
