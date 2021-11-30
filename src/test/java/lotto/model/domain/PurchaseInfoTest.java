package lotto.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PurchaseInfoTest {

    PurchaseInfo purchaseInfo;

    @ParameterizedTest
    @ValueSource(ints = { -1, -2, -3, 100, 900})
    @DisplayName("amount 가 1000보다 작으면 예외 발생")
    void amountUnderZeroThrowException(int amount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> purchaseInfo = new PurchaseInfo(amount))
                .withMessage("로또를 구매하지 않았습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = { "14000,14", "2000,2", "2600,2" })
    @DisplayName("amount 로 구매한 로또 개수 확인하기")
    void getLotteryCountTest(int amount, int expected){
        purchaseInfo = new PurchaseInfo(amount);
        assertThat(purchaseInfo.getLotteryCount()).isEqualTo(expected);
    }
}