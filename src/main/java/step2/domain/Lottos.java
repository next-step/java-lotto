package step2.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;
    private LottoMoney lottoMoney = new LottoMoney();
    private int money;
    private Map<Integer, Integer> lottoMatchCount = new HashMap<>();
    private int matchCount = 0;

    public Lottos(int money) {
        lottos = createLottos(money);
        this.money = money;
    }

    private List<Lotto> createLottos(int money) {
        List<Lotto> lotto = new ArrayList<>();
        int count = money / lottoMoney.getMoney();
        for (int i = 0; i < count; i++) {
            lotto.add(new Lotto());
        }
        return lotto;
    }

    public Map<Integer, Integer> matchLotto(String winnerNumber) {
        mapInit();
        count(winnerNumber);

        return this.lottoMatchCount;
    }

    private void mapInit() {
        this.lottoMatchCount.put(3,0);
        this.lottoMatchCount.put(4,0);
        this.lottoMatchCount.put(5,0);
        this.lottoMatchCount.put(6,0);
    }

    private void count(String winnerNumber) {
        for (Lotto lotto : lottos) {
            more3match(lotto, winnerNumber);
        }
    }

    private void more3match(Lotto lotto, String winnerNumber) {
        matchCount = new Lotto(lotto.getLottoNumber(), winnerNumber).getMatchesCount();
        if (matchCount >= 3) {
            this.lottoMatchCount.put(matchCount, lottoMatchCount.getOrDefault(matchCount,0) + 1);
        }
    }

    public long totalBenefit() {
        long total = 0;
        List<Integer> benefitList = lottoMatchCount.keySet()
                .stream()
                .filter(i -> lottoMatchCount.get(i) > 0)
                .collect(Collectors.toList());
        for (int benefit : benefitList) {
            System.out.println(WinnerPriceType.of(benefit).winningAmount + " " + lottoMatchCount.get(benefit));
            total += WinnerPriceType.of(benefit).winningAmount * lottoMatchCount.get(benefit);
        }
        System.out.println(total);
        System.out.println(this.money);
        return total / this.money;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
