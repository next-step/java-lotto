package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PurchaseInfoTest {

    PurchaseInfo purchaseInfo;

    @ParameterizedTest
    @ValueSource(ints = { -1, -2, -3})
    @DisplayName("파라미터가 음수면 예외 발생")
    void amountUnderZeroThrowException(int amount){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> purchaseInfo = new PurchaseInfo(amount))
                .withMessage("구매액은 음수일 수 없습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = { "14000,14", "200,0", "2000,2", "2600,2" })
    @DisplayName("파라미터가 음수면 예외 발생")
    void getLottoCountTest(int amount, int expected){
        purchaseInfo = new PurchaseInfo(amount);
        assertThat(purchaseInfo.getLottoCount()).isEqualTo(expected);
    }
}