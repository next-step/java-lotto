package lottery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchasePriceTest {

    @DisplayName("PurchasePrice 객체 정상 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {500, 1000, 1500})
    public void makePurchasePriceObject(int userInput) {
        PurchasePrice purchasePrice = new PurchasePrice(userInput);

        assertThat(purchasePrice.getPurchasePrice())
                .isEqualTo(userInput);
    }
}
