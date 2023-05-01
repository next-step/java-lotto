package step2.domain;

import java.util.List;

public class PurchasedLotto {

    private final List<Lotto> lottoList;

    public PurchasedLotto(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public int getSumOfWinningMoney() {
        int sum = 0;
        for (Lotto lotto : lottoList) {
            sum += lotto.getPrizedMoney();
        }
        return sum;
    }

    public int getCountOfRank(Ranking ranking) {
        return (int) lottoList.stream().filter(lotto -> lotto.getRanking() == ranking).count();
    }

    public List<Lotto> get() {
        return this.lottoList;
    }
}
