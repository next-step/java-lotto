package lotto.domain;

public class LottoPrice {

    private static final int UNIT_PRICE = 1000;

    private final int price;
    private final int amount;

    public LottoPrice(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException("로또를 구매할 장수는 양수여야 합니다.");
        }

        if (price % UNIT_PRICE != 0) {
            throw new IllegalArgumentException("로또의 1장당 가격은 1,000원입니다. 원하는 장수 만큼의 금액을 입력해주세요.");
        }

        this.price = price;
        this.amount = price / UNIT_PRICE;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }
}
