package lottery;

import lottery.domain.PurchasePrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PurchasePriceTest {

    @DisplayName("PurchasePrice 객체 정상 생성 테스트")
    @ParameterizedTest
    @ValueSource(longs = {500, 1000, 1500})
    public void makePurchasePriceObject(long userInput) {
        PurchasePrice purchasePrice = new PurchasePrice(userInput);

        assertThat(purchasePrice.getPurchasePrice())
                .isEqualTo(userInput);
    }

    @DisplayName("PurchasePrice 객체 생성 실패 (0 이하)")
    @ParameterizedTest
    @ValueSource(longs = {0, -30, -999})
    public void throwExceptionOnMakingPurchasePriceObject(long userInput) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                   new PurchasePrice(userInput);
                });
    }
}
