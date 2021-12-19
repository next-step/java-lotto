package lottery.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ManualTicketCountTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, -100})
    @DisplayName("0보다 작은 수동 구매 수")
    void invalidParam(final int manualTicketCount) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> ManualTicketCount.from(manualTicketCount, PurchasePrice.from(10000)));
    }

    @ParameterizedTest
    @CsvSource(value = {"2:1000"}, delimiter = ':')
    @DisplayName("구매 금액 보다 더 많은 티켓 구매 시도 실패")
    void exceededBudget(final int manualTicketCount, final int purchasePrice) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> ManualTicketCount.from(manualTicketCount, PurchasePrice.from(purchasePrice)));
    }

    @ParameterizedTest
    @CsvSource(value = {"0:10000:10", "5:10000:5", "10:10000:0"}, delimiter = ':')
    @DisplayName("구매 금액 보다 더 많은 티켓 구매 시도 실패")
    void autoLotteryCount(final int manualTicketCountValue, final int purchasePriceValue,
        final int autoTicketCountValue) {
        final PurchasePrice purchasePrice = PurchasePrice.from(purchasePriceValue);
        final ManualTicketCount manualTicketCount = ManualTicketCount.from(manualTicketCountValue,
            purchasePrice);
        AutoTicketCount autoTicketCount = manualTicketCount.autoLotteryCount(purchasePrice);

        assertThat(autoTicketCount.getValue())
            .isEqualTo(autoTicketCountValue);
    }

}
