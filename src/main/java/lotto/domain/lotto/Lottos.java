package lotto.domain.lotto;

import lotto.constants.LottoConstants;
import lotto.constants.Winning;
import lotto.domain.lotto.strategy.GenerateStrategy;
import lotto.dto.Summary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;
    private final long purchasePrice;

    public Lottos(List<Lotto> lottos, long purchasePrice) {
        this.lottos = new ArrayList<>(lottos);
        this.purchasePrice = purchasePrice;
    }

    public static Lottos of(int purchasePrice, GenerateStrategy strategy) {
        int lottoCount = lottoCount(purchasePrice);

        List<Lotto> lottoList = new ArrayList<>();
        for (int index = 0; index < lottoCount; index++) {
            lottoList.add(Lotto.of(strategy));
        }

        return new Lottos(lottoList, purchasePrice);
    }

    private static int lottoCount(int purchasePrice) {
        int lottoCount = purchasePrice / LottoConstants.PRICE_PER_TICKET;
        validation(lottoCount);
        return lottoCount;
    }

    private static void validation(int lottoCount) {
        if (noPurchase(lottoCount)) {
            throw new IllegalArgumentException(LottoConstants.PURCHASE_ERROR_MESSAGE);
        }
    }

    private static boolean noPurchase(int lottoCount) {
        return lottoCount == 0;
    }

    public Summary match(Lotto jackpot) {
        List<Winning> winnings = new ArrayList<>();

        for (Lotto lotto : lottos) {
            Winning winning = jackpot.match(lotto);
            winnings.add(winning);
        }

        return winningResult(winnings);
    }

    public Summary winningResult(List<Winning> winnings) {
        Summary summary = new Summary();
        summary.setFirstCount(winningCount(winnings, Winning.FIRST));
        summary.setSecondCount(winningCount(winnings, Winning.SECOND));
        summary.setThirdCount(winningCount(winnings, Winning.THIRD));
        summary.setFourthCount(winningCount(winnings, Winning.FOURTH));
        summary.setProfitRate(profitRate(winnings));

        return summary;
    }

    private float profitRate(List<Winning> winnings) {
        return (float) prizeTotal(winnings) / (float) purchasePrice;
    }

    private long winningCount(List<Winning> winnings, Winning winning) {
        return winnings.stream()
                .filter(winning::equals)
                .count();
    }

    private long prizeTotal(List<Winning> winnings) {
        return winnings.stream()
                .mapToLong(Winning::prize)
                .sum();
    }

    public int size() {
        return lottos.size();
    }

    public List<Lotto> lottos() {
        return Collections.unmodifiableList(lottos);
    }
}
