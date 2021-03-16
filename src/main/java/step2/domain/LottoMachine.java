package step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoMachine {

    private static final int WIN_NUMBER_LENGTH = 6;
    private final Lottos lottos;
    private LottoStatistics lottoStatistics;
    private Money money;

    //테스트를 위한 생성자
    public LottoMachine() {
        this.lottos = new Lottos();
    }

    public LottoMachine(int money) {
        this.lottos = new Lottos();
        this.money = new Money(money);
    }

    //테스트를 위한 생성자
    public LottoMachine(Lottos lottos) {
        this.lottos = lottos;
    }

    public Lottos createLotto() {
        return lottos.createLottoList(getLottoCount(money));
    }

    private int getLottoCount(Money money) {
        return money.divideMoneyByPrice();
    }

    public List<Integer> getRankOfLottos(List<LottoNumber> winNumber) {
        return lottos.getRankOfLotto(winNumber);
    }


    public List<LottoNumber> toLottoNumberList(String winNumber) {
        String[] stringNumbers = winNumber.split(",");
        valid(stringNumbers);
        List<LottoNumber> collect;
        try {
            collect = Arrays.stream(stringNumbers)
                    .map(Integer::parseInt)
                    .map(LottoNumber::new)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new RuntimeException("로또 당첨번호에 숫자가 아닌 부분이 있습니다.");
        }
        return collect;
    }

    private void valid(String[] stringNumbers) {
        if (stringNumbers.length != WIN_NUMBER_LENGTH) {
            throw new IllegalArgumentException("당첨번호가 6개가 아닙니다.");
        }
    }

    public List<Boolean> getMatchOfBonus(LottoNumber lottoNumber) {
        return lottos.matchOfBonus(lottoNumber);
    }

    public Map<Integer, List<Rank>> statistics(List<LottoNumber> winNumbers, LottoNumber bonusNumber) {
        List<Integer> rankOfLottos = getRankOfLottos(winNumbers);
        lottoStatistics = new LottoStatistics(rankOfLottos, money);
        return lottoStatistics.statistics(getMatchOfBonus(bonusNumber));
    }

    public double getEarningRate() {
        return lottoStatistics.getEarningRate();
    }
}
