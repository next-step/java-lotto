package lotto;
import java.text.DecimalFormat;
import java.util.*;

import static lotto.LottoStore.LOTTO_PRICE;

public class LottoResult {

    private final int PRICE_1 = 2000000000;
    private final int PRICE_2 = 1500000;
    private final int PRICE_3 = 50000;
    private final int PRICE_4 = 5000;

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

    private int calculateIncome() {
        return winnerNumbers.matchCount(lottos, 3) * PRICE_4
                + winnerNumbers.matchCount(lottos, 4) * PRICE_3
                + winnerNumbers.matchCount(lottos, 5) * PRICE_2
                + winnerNumbers.matchCount(lottos, 6) * PRICE_1;
    }

    public int matchCount(int count){
        return winnerNumbers.matchCount(lottos, count);
    }

}
