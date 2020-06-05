package lottery;

import lottery.domain.PurchasePrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PurchasePriceTest {

    private static Stream<Arguments> mockPurchasePriceBuilder() {
        return Stream.of(
                Arguments.of(1000, 0),
                Arguments.of(1000, 1),
                Arguments.of(2000, 0),
                Arguments.of(2000, 1),
                Arguments.of(2000, 2),
                Arguments.of(4444, 3)
        );
    }

    @DisplayName("PurchasePrice 객체 정상 생성 테스트")
    @ParameterizedTest
    @MethodSource("mockPurchasePriceBuilder")
    public void makePurchasePriceObject(long priceInput, int manualTicketCounts) {
        PurchasePrice purchasePrice = PurchasePrice.of(userInput, manualTicketCounts);

        int automaticTicketCounts = (int) ((priceInput - (1000 * manualTicketCounts)) / 1000);

        assertThat(purchasePrice.getPurchasePrice())
                .isEqualTo(userInput);
        assertThat(purchasePrice.getManualTicketCounts())
                .isEqualTo(manualTicketCounts);
        assertThat(purchasePrice.getAutomaticTicketCounts())
                .isEqualTo(automaticTicketCounts);
    }

    @DisplayName("PurchasePrice 객체 생성 실패 테스트")
    @ParameterizedTest
    @CsvSource({"1000, 2", "1000, -1", "999, 0", "-300, 0", "4444, 5"})
    public void throwExceptionOnMakingPurchasePriceObject(long priceInput, int manualTicketCounts) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    PurchasePrice.of(priceInput, manualTicketCounts);
                });
    }
}
