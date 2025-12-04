package lottogame.model.price;

import static java.lang.Math.floor;

import lottogame.model.winner.WinnerResult;

public class LottoPurchasePrice {
    private static final int UP_TWO_DECIMAL_PLACE = 100;
    private static final double DOWN_TWO_DECIMAL_PLACE = 100.0;

    private final int price;

    public LottoPurchasePrice(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException("로또가격은 0보다 커야 합니다.");
        }

        this.price = price;
    }

    public int calculateLottoCount(int perLottoPrice) {
        if (perLottoPrice < 0) {
            throw new IllegalArgumentException("잘못된 값입니다.");
        }

        return price / perLottoPrice;
    }

    public double calculateRateOfReturn(int totalWinReturn) {
        if (totalWinReturn < 0) {
            throw new IllegalArgumentException("잘못된 값입니다.");
        }

        double rateOfReturn = (double) totalWinReturn / this.price * UP_TWO_DECIMAL_PLACE;

        return floor(rateOfReturn) / DOWN_TWO_DECIMAL_PLACE;
    }
}
