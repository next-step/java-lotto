package lotto.model;

import java.util.List;

public class LottoWallet {
    private final List<Lotto> lottos;

    public LottoWallet(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public Lotto getLotto(int index) {
        return lottos.get(index);
    }

    public int calculateProfit(LottoWinningNumber winningNumber){
        int profit = 0;
        for (Lotto lotto : lottos) {
            LottoPrize rank = winningNumber.getRank(lotto);
            profit += rank.getAmount();
        }
        return profit;
    }
}
