package lotto.domain.data;

import java.math.BigDecimal;

public class PriceLotto {

    private BigDecimal price;

    private PriceLotto(BigDecimal price) {
        this.price = price;
    }

    public static PriceLotto of(int price) {
        validateNegativePrice(price);
        return new PriceLotto(BigDecimal.valueOf(price));
    }

    public void boughtLotto(int count, int pricePerOneLotto) {
        validateEnoughPrice(count, pricePerOneLotto);
        price = price.subtract(BigDecimal.valueOf(count * pricePerOneLotto));
    }

    private static void validateNegativePrice(int price) {
        if(price < 0) {
            throw new IllegalArgumentException("마이너스 금액은 생성할 수 없습니다.");
        }
    }

    private void validateEnoughPrice(int count, int pricePerOneLotto) {
        if(price.intValue() < count * pricePerOneLotto) {
            throw new IllegalArgumentException("남은 잔액으로는 해당 수만큼 로또를 구매할 수 없습니다.");
        }
    }

    public BigDecimal get() {
        return price;
    }

    public int getIntValue() {
        return price.intValue();
    }
}
