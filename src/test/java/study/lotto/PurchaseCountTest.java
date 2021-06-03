package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.lotto.domain.PurchaseCount;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseCountTest {

    @DisplayName("입력한 금액만큼 구매 가능한 장수를 확인한다")
    @ParameterizedTest
    @CsvSource({"14000,14", "2000,2", "1500,1", "400,0"})
    public void purchaseableLottoTest(BigDecimal purchaseAmount, int expected) {

        assertThat(new PurchaseCount(purchaseAmount).value()).isEqualTo(expected);
    }

}
