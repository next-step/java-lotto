package lotto.domain;

public class LottoStatistics {
    private final EarningRate earningRate;
    private final LottoPrizes lottoPrizes;

    public LottoStatistics(EarningRate earningRate, LottoPrizes lottoPrizes) {
        validate(earningRate, lottoPrizes);
        this.earningRate = earningRate;
        this.lottoPrizes = lottoPrizes;
    }

    private void validate(EarningRate earningRate, LottoPrizes lottoPrizes) {
        if (earningRate == null) {
            throw new IllegalArgumentException("earningRate는 null 일 수 없습니다.");
        }
        if (lottoPrizes == null) {
            throw new IllegalArgumentException("lottoPrizes는 null 일 수 없습니다.");
        }
    }

    public EarningRate getEarningRate() {
        return earningRate;
    }

    public long getPrizeCount(LottoPrize lottoPrize) {
        return lottoPrizes.countPrize(lottoPrize);
    }

    public static LottoStatistics from(LottoPrizes lottoPrizes) {
        return new LottoStatistics(
                lottoPrizes.toEarningRate(),
                lottoPrizes
        );
    }
}
