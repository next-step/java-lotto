package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGame {

    List<Lotto> lottos;

    public LottoGame(long lottoPrice, long purchaseBudget) {
        this(Stream.generate(Lotto::new)
                .limit(purchaseBudget / lottoPrice)
                .collect(Collectors.toList())
        );
    }

    public LottoGame(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int hasLottoCount() {
        return lottos.size();
    }

    public double produceStatistics(long lottoPrice, Lotto lastWeekWin) {
        long totalPrize = 0L;
        for (Lotto l : lottos) {
            int i = l.countMatchedNumber(lastWeekWin);
            totalPrize += RANK.receivePrize(i);
        }

        return Math.floor((double) totalPrize / lottoPrice * 100) / 100.0;
    }
}
