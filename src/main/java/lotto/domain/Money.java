package lotto.domain;

import java.math.BigDecimal;

import static lotto.LottoResult.rankOfMatch;
import static lotto.domain.Rank.values;

@SuppressWarnings("BigDecimalMethodWithoutRoundingCalled")
public class Money {

    private static final int DEFAULT_LOTTO_PRICE = 1000;
    private static final int DEFAULT_MANUAL_PURCHASE_LOTTO_NUMBER = 0;

    private final int amount;
    private final int price;
    private final int manualPurchaseLottoNumber;

    public Money(final int amount) {
        this(amount, DEFAULT_LOTTO_PRICE, DEFAULT_MANUAL_PURCHASE_LOTTO_NUMBER);
    }

    public Money(final int amount, final int manualPurchaseLottoNumber) {
        this(amount, DEFAULT_LOTTO_PRICE, manualPurchaseLottoNumber);
    }

    public Money(final int amount, final int price, final int manualPurchaseLottoNumber) {

        if (amount < 0 || price < 1 || manualPurchaseLottoNumber < 0) {
            throw new IllegalArgumentException();
        }

        this.amount = amount;
        this.price = price;
        this.manualPurchaseLottoNumber = manualPurchaseLottoNumber;
    }

    public int calculateCountPurchased() {
        return new BigDecimal(this.amount / this.price).intValue();
    }

    public int calculateLottoCountToPurchasedAutomatically() {
        return calculateCountPurchased() - this.manualPurchaseLottoNumber;
    }

    public double calculateRate(final LottoDto lottoDto) {
        return new BigDecimal(calculatorRewordAmount(lottoDto)).divide(new BigDecimal(this.amount)).doubleValue();
    }

    public boolean hasManualPurchaseLottoNumber() {
        return this.manualPurchaseLottoNumber > 0;
    }

    public int getManualPurchaseLottoNumber() {
        return manualPurchaseLottoNumber;
    }

    private int calculatorRewordAmount(final LottoDto lottoDto) {
        int sum = 0;
        for (Rank rank : values()) {
            sum += multiplicationRankOfMatchSizeWithWinningMoney(lottoDto, rank);
        }
        return sum;
    }

    private int multiplicationRankOfMatchSizeWithWinningMoney(final LottoDto lottoDto, final Rank rank) {
        return Lottos.rankOfMatchSize(rankOfMatch(lottoDto, rank)) * rank.getWinningMoney();
    }

}
