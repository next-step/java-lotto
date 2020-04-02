package step3.domain;

public class BuyInfo {
    private static final int ZERO = 0;
    private static final int ONE_GAME_PRICE = 1000;
    private int totalPrice;
    private int totalCount;

    public BuyInfo(int totalPrice) {
        if (totalPrice <= ZERO) {
            throw new IllegalArgumentException("로또 구매가격은 0보다 커야합니다.");
        }
        if (totalPrice < ONE_GAME_PRICE) {
            throw new IllegalArgumentException("구매가격은 로또 장당가격인 " + ONE_GAME_PRICE + "보다 큰 금액 입력");
        }
        this.totalPrice = totalPrice;
        this.totalCount = totalPrice / ONE_GAME_PRICE;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getAutoCount() {
        return autoCount;
    }

    public int getManualCount() {
        return manualCount;
    }

    private int autoCount = 0;
    private int manualCount = 0;

    public int getTotalCount() {
        return totalCount;
    }

    public BuyInfo(int totalPrice, String[] manualCount) {
        if (totalPrice <= ZERO) {
            throw new IllegalArgumentException("로또 구매가격은 0보다 커야합니다.");
        }
        if (totalPrice < ONE_GAME_PRICE) {
            throw new IllegalArgumentException("구매가격은 로또 장당가격인 " + ONE_GAME_PRICE + "보다 큰 금액 입력");
        }
        this.totalPrice = totalPrice;
        this.manualCount = manualCount.length;
        this.totalCount = totalPrice / ONE_GAME_PRICE;
        this.autoCount = totalCount - this.manualCount;
    }
}
