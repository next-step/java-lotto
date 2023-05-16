package lotto;
import java.text.DecimalFormat;
import java.util.*;

import static lotto.LottoStore.LOTTO_PRICE;

public class LottoResult {

    private final List<Lotto> lottos;
    private final WinningLotto winnerNumbers;

    public LottoResult(List<Lotto> lottos, WinningLotto winningLotto) {
        this.lottos = lottos;
        this.winnerNumbers = winningLotto;
    }

    public String calculateRateOfReturn() {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format((double) calculateIncome() / calculateExpenditure());

    }

    private int calculateExpenditure() {
        return lottos.size() * LOTTO_PRICE;
    }

    private long calculateIncome() {
        return Arrays.stream(Rank.values())
                .mapToLong(rank -> winnerNumbers.matchRank(lottos, rank) * rank.getWinningMoney())
                .sum();
    }

    public long matchRank(Rank rank){
        return winnerNumbers.matchRank(lottos, rank);
    }

}
