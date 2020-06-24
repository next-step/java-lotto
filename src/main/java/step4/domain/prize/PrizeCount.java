package step4.domain.prize;

import step4.view.OutputView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PrizeCount {

    private List<PrizeAdder> prizes = new ArrayList<>();
    private static PrizeCount prizeCount;

    private PrizeCount() {
        for (Prize prize : Prize.values()) {
            prizes.add(new PrizeAdder(prize));
        }
    }

    public static PrizeCount getInstance() {
        if (Objects.isNull(prizeCount)) {
            prizeCount = new PrizeCount();
        }
        return prizeCount;
    }

    private class PrizeAdder {
        Prize prize;
        int prizeSum = 0;

        public PrizeAdder(Prize prize) {
            this.prize = prize;
        }

        public Prize getPrize() {
            return prize;
        }

        public void addPrizeSum() {
            prizeSum++;
        }

        public int getPrizeSum() {
            return prizeSum;
        }

        public long getPrizePriceSum() {
            return prize.getPrizePrice() * prizeSum;
        }

        public boolean isMatchedNumber(Prize prize) {
            return this.prize.getMatchedNumber() == prize.getMatchedNumber()
                    && this.prize.isBonusNumberMatching() == prize.isBonusNumberMatching();
        }

        public boolean isMatchedBonusNumber(Prize prize) {
            return this.prize.isBonusNumberMatching() == prize.isBonusNumberMatching();
        }
    }

    public void prizeAdd(Prize prize) {
        prizes.stream()
                .filter(prizeAdder -> prizeAdder.isMatchedNumber(prize)
                        && prizeAdder.isMatchedBonusNumber(prize)
                )
                .findFirst()
                .get()
                .addPrizeSum();
    }

    public int getPrizeSum(Prize prize) {
        return prizes.stream()
                .filter(prizeAdder -> prizeAdder.isMatchedNumber(prize) &&
                        prizeAdder.isMatchedBonusNumber(prize)
                )
                .findFirst()
                .get()
                .getPrizeSum();
    }

    public List<PrizeAdder> getPrizes() {
        return Collections.unmodifiableList(prizes);
    }


    public void showPrizeCounts() {
        OutputView.outputPrizeList(this);
    }

    public void outputWinningResult() {
        OutputView.outputWinningResult(getPrizeTotalSum());

    }

    private BigDecimal getPrizeTotalSum() {
        return BigDecimal.valueOf(
                prizes.stream()
                        .mapToLong(
                                prizes -> prizes.getPrizePriceSum()
                        ).sum())
                .divide(
                        BigDecimal.valueOf(prizes.stream()
                                .mapToLong(PrizeAdder::getPrizeSum).sum())
                        , 3
                        , BigDecimal.ROUND_HALF_EVEN);
    }

}
