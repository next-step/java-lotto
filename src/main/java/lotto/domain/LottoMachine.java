package lotto.domain;

import lotto.constant.Prize;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;
    private final Amount cashAmount;
    private final Amount manualAmount;
    private final LottoNumbers balls;
    private final ProfitRateStrategy profitRateStrategy;
    private final LottoCreateStrategy lottoCreateStrategy;

    private LottoMachine(Builder builder) {
        validateCashAmount(builder.cashAmount);
        this.cashAmount = builder.cashAmount;
        this.manualAmount = builder.manualAmount;
        this.balls = LottoNumbers.of();
        this.profitRateStrategy = builder.profitRateStrategy;
        this.lottoCreateStrategy = builder.lottoCreateStrategy;
    }

    private static void validateCashAmount(Amount cashAmount) {
        if (cashAmount.isLessThan(LOTTO_PRICE)) {
            throw new IllegalArgumentException("로또 구입 금액은 최소 " + LOTTO_PRICE + "원 이상이어야 합니다.");
        }
    }

    public List<Lotto> createAutomatically() {
        int autoPurchaseQuantity = manualAmount.calculateAutoPurchaseQuantity(calculatePurchaseQuantity());
        return IntStream.range(0, autoPurchaseQuantity)
                .mapToObj(i -> lottoCreateStrategy.create(balls))
                .collect(Collectors.toList());
    }

    public Lotto createManually(Set<LottoNo> numbers) {
        return new Lotto(numbers);
    }

    public int calculatePurchaseQuantity() {
        return cashAmount.calculatePurchaseQuantity(LOTTO_PRICE);
    }

    public EnumMap<Prize, Integer> checkLottoPrize(List<Lotto> lottoList, Set<LottoNo> winningNumbers, LottoNo bonusNumber) {
        EnumMap<Prize, Integer> countMap = new EnumMap<>(Prize.class);
        for (Lotto lotto : lottoList) {
            int count = match(lotto, winningNumbers);
            Prize prize = Prize.calculateRank(count, isBonusNumberMatch(lotto, bonusNumber));
            countMap.merge(prize, 1, Integer::sum);
        }
        return countMap;
    }

    private int match(Lotto lotto, Set<LottoNo> winningNumbers) {
        return lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .collect(Collectors.toList()).size();
    }

    private boolean isBonusNumberMatch(Lotto lotto, LottoNo bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public String calculateProfitRate(EnumMap<Prize, Integer> countMap) {
        return profitRateStrategy.calculateProfitRate(countMap, cashAmount);
    }

    public static class Builder {
        private Amount cashAmount;
        private Amount manualAmount;
        private ProfitRateStrategy profitRateStrategy;
        private LottoCreateStrategy lottoCreateStrategy;

        public Builder cashAmount(Amount cashAmount) {
            this.cashAmount = cashAmount;
            return this;
        }

        public Builder manualAmount(Amount manualAmount) {
            this.manualAmount = manualAmount;
            return this;
        }

        public Builder profitRateStrategy(ProfitRateStrategy profitRateStrategy) {
            this.profitRateStrategy = profitRateStrategy;
            return this;
        }

        public Builder lottoCreateStrategy(LottoCreateStrategy lottoCreateStrategy) {
            this.lottoCreateStrategy = lottoCreateStrategy;
            return this;
        }

        public LottoMachine build() {
            return new LottoMachine(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
