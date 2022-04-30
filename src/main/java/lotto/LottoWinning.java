package lotto;

import java.util.*;

public class LottoWinning {
    private static final String FLOOR = "%.2f";
    private final LottoNumber winningNumber;
    private final Map<Rank, Integer> results = new HashMap<>();
    private final Lotto lotto;

    public LottoWinning(String winningNumber, Lotto lotto) {
        this.winningNumber = new LottoNumber(winningNumber);
        this.lotto = lotto;
        setWinningResults();
    }

    private void setWinningResults() {
        for (LottoNumber lottoNumber : lotto.getLottoNumbers()) {
            Rank rank = lottoNumber.getRank(winningNumber);
            results.put(rank, getWinningCount(rank) + 1);
        }
    }

    public int getWinningCount(Rank rank) {
        Integer count = results.get(rank);
        if (count == null) {
            return 0;
        }
        return count;
    }

    public String getReturnRate() {
        Iterator<Rank> keys = results.keySet().iterator();
        int winningMoneySum = 0;
        while (keys.hasNext()) {
            Rank rank = keys.next();
            int winningCount = results.get(rank);
            int winningMoney = rank.getWinningMoney();
            winningMoneySum += winningCount * winningMoney;
        }
        return String.format(FLOOR, Math.floor((double) winningMoneySum / lotto.getBuyPrice() * 100) / 100.0);
    }
}
