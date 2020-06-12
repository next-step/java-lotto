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

    public void boughtLotto(int pricePerLotto, int autoLottoCount, int manualLottoCount) {
        validateEnoughPrice(pricePerLotto, autoLottoCount, manualLottoCount);
        price = price.subtract(BigDecimal.valueOf((autoLottoCount + manualLottoCount) * pricePerLotto));
    }

    private static void validateNegativePrice(int price) {
        if(price < 0) {
            throw new IllegalArgumentException("마이너스 금액은 생성할 수 없습니다.");
        }
    }

    public void validateEnoughPrice(int pricePerLotto, int autoLottoCount, int manualLottoCount) {
        if(price.intValue() < pricePerLotto ||
                price.intValue() < pricePerLotto * (autoLottoCount + manualLottoCount)) {
            throw new IllegalArgumentException("현재 금액으로는 로또를 구매할 수 없습니다.");
        }
    }

    public BigDecimal get() {
        return price;
    }

    public int getIntValue() {
        return price.intValue();
    }
}
