package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
}