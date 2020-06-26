package step4.domain.prize;

import step4.view.OutputView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PrizeCount {

    private List<Prize> prizes = new ArrayList<>();

    public PrizeCount() {
        for (Prize prize : Prize.values()) {
            prizes.add(prize);
        }
    }

    public static PrizeCount of() {
        return new PrizeCount();
    }

    public boolean isMatchedNumber(Prize prize, Prize inputPrize) {
        return prize.getMatchedNumber() == inputPrize.getMatchedNumber()
                && prize.isBonusNumberMatching() == inputPrize.isBonusNumberMatching();
    }

    public boolean isMatchedBonusNumber(Prize prize, Prize inputPrize) {
        return prize.isBonusNumberMatching() == inputPrize.isBonusNumberMatching();
    }

    public void prizeAdd(Prize inputPrize) {
        prizes.stream()
                .filter(prize -> isMatchedNumber(prize, inputPrize)
                        && isMatchedBonusNumber(prize, inputPrize)
                )
                .forEach(prize -> prize.addMatchedCount());
    }

    public long getPrizeSum(Prize inputPrize) {
        return prizes.stream()
                .filter(prize -> isMatchedNumber(prize, inputPrize) &&
                        isMatchedBonusNumber(prize, inputPrize)
                )
                .findFirst()
                .get()
                .getPrizePriceSum();
    }

    public List<Prize> getPrizes() {
        return Collections.unmodifiableList(prizes);
    }

    public void showPrizeCounts() {
        OutputView.outputPrizeList(this);
    }

    public BigDecimal getPrizeTotalSum() {
        return BigDecimal.valueOf(
                prizes.stream()
                        .mapToLong(
                                prizes -> prizes.getPrizePriceSum()
                        ).sum())
                .divide(
                        BigDecimal.valueOf(prizes.stream()
                                .mapToLong(Prize::getPrizePriceSum).sum())
                        , 3
                        , BigDecimal.ROUND_HALF_EVEN);
    }

}
