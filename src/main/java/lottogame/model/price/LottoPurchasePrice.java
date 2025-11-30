package lottogame.model.price;

public class LottoPurchasePrice {
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

        return (double) totalWinReturn / this.price;
    }

    public int price() {
        return this.price;
    }
}
