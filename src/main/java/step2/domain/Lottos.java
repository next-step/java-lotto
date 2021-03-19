package step2.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    private List<Lotto> lottos;
    private int money;
    private Map<Integer, Integer> lottoMatchCount = new HashMap<>();
    private int matchCount = 0;

    public Lottos(int money) {
        lottos = createLottos(money);
        this.money = money;
    }

    private List<Lotto> createLottos(int money) {
        List<Lotto> lotto = new ArrayList<>();
        int count = money / 1000;
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

    public double totalBenefit() {
        double totalWinnerPrice = 0;
        for (Lotto lotto : lottos) {
            totalWinnerPrice += lotto.winnerPrice();
        }
        System.out.println(totalWinnerPrice + "/" + money) ;
        return totalWinnerPrice / money;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
