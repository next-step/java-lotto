package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoWinning {
    private static final String FLOOR = "%.2f";
    private final LottoNumber winningNumber;
    private final Map<Rank, Integer> results = new HashMap<>();
    private final Lotto lotto;

    public LottoWinning(String winningNumber, Lotto lotto) {
        this.winningNumber = new LottoNumber(winningNumber);
        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }
        this.lotto = lotto;
        setResults();
    }

    private void setResults() {
        for (LottoNumber lottoNumber : lotto.getLottoNumbers()) {
            Rank rank = lottoNumber.getRank(winningNumber);
            results.replace(rank, getWinningCount(rank) + 1);
        }
    }

    public int getWinningCount(Rank rank) {
        return results.get(rank);
    }

    public int getWinningCountByCountOfMatch(int countOfMatch) {
        return results.get(Rank.valueOf(countOfMatch));
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
