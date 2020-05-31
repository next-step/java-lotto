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
    @ValueSource(longs = {2000, 1000, 1500})
    public void makePurchasePriceObject(long userInput) {
        PurchasePrice purchasePrice = PurchasePrice.from(userInput);

        assertThat(purchasePrice.getPurchasePrice())
                .isEqualTo(userInput);
    }

    @DisplayName("PurchasePrice 객체 생성 실패(로또 티켓 비용 1000원 미만) 테스트")
    @ParameterizedTest
    @ValueSource(longs = {0, -30, 300, 500, 999})
    public void throwExceptionOnMakingPurchasePriceObject(long userInput) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    PurchasePrice.from(userInput);
                });
    }

    @DisplayName("구입 가격으로 살 수 있는 티켓 개수 반환 테스트")
    @ParameterizedTest
    @ValueSource(longs = {1000, 2000, 3000, 4444})
    public void getPurchasableLotteryTicketCounts(long userInput) {
        PurchasePrice purchasePrice = PurchasePrice.from(userInput);

        assertThat(purchasePrice.getPurchasableLotteryTicketCounts())
                .isEqualTo(userInput / 1000);
    }
}
