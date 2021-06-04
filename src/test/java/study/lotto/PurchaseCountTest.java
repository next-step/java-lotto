package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.lotto.domain.PurchaseCount;
import study.lotto.exception.WrongSelfPickCountException;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseCountTest {

    @DisplayName("입력한 금액만큼 구매 가능한 장수를 확인한다")
    @ParameterizedTest
    @CsvSource({"14000,14", "2000,2", "1500,1", "400,0"})
    public void purchaseCountTest(BigDecimal purchaseAmount, int expected) {

        assertThat(new PurchaseCount(purchaseAmount).value()).isEqualTo(expected);
    }

    @DisplayName("수동 구매 가능한 개수인지 확인한다")
    @Test
    public void isaVailableTest() {
        PurchaseCount purchaseCount = new PurchaseCount(BigDecimal.valueOf(3000));

        purchaseCount.isaAvailable(3);
        assertThatThrownBy(() -> purchaseCount.isaAvailable(4))
                .isInstanceOf(WrongSelfPickCountException.class);
    }

    @DisplayName("자동 구매 가능한 개수")
    @ParameterizedTest
    @CsvSource({"1,4", "2,3", "4,1", "5,0"})
    public void availableCountTest(int selfPickCount, int expected) {
        PurchaseCount purchaseCount = new PurchaseCount(BigDecimal.valueOf(5000));

        assertThat(purchaseCount.availableCount(selfPickCount)).isEqualTo(expected);
    }

}
