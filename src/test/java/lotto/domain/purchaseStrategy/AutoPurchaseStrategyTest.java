package lotto.domain.purchaseStrategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AutoPurchaseStrategyTest {

    private static final int LIMIT_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    @DisplayName("6개의 숫자 반환")
    @SuppressWarnings("NonAsciiCharacters")
    @Test
    void generateLottoNumber_6개_숫자() {
        PurchaseStrategy purchaseStrategy = new AutoPurchaseStrategy();
        assertThat(purchaseStrategy.generateLottoNumber().size()).isEqualTo(LIMIT_SIZE);
    }

    @DisplayName("1부터 45까지의 숫자 반환")
    @SuppressWarnings("NonAsciiCharacters")
    @Test
    void generateLottoNumber_1부터_45까지_숫자() {
        PurchaseStrategy purchaseStrategy = new AutoPurchaseStrategy();
        for (int number : purchaseStrategy.generateLottoNumber()) {
            assertThat(number).isBetween(MIN_NUMBER, MAX_NUMBER);
        }
    }

}
