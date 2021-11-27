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
    void amountUnderZeroThrowException(int amount){
        purchaseInfoValidationException(amount,1,"로또를 구매하지 않았습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = { "14000,14", "2000,2", "2600,2" })
    @DisplayName("amount 로 구매한 로또 개수 확인하기")
    void getLotteryCountTest(int amount, int expected){
        purchaseInfo = new PurchaseInfo(amount, 1);
        assertThat(purchaseInfo.getLotteryCount()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = { -1, -2, -3, -4 })
    @DisplayName("manualCount가 0보다 작으면 예외 발생 테스트")
    void manualCountUnderZeroExceptionTest(int manualCount) {
        purchaseInfoValidationException(1000, manualCount, "0보다 큰 숫자를 입력하셔야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = { 2, 3, 4, 5 })
    @DisplayName("manualCount가 구매할 수 있는 로또 개수보다 크면 예외 발생 테스트")
    void manualCountOverLotteryCountExceptionTest(int manualCount) {
        purchaseInfoValidationException(1000, manualCount, "수동으로 구매할 수 있는 로또 수를 넘었습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = { "2,4", "3,3", "4,2", "6,0" })
    @DisplayName("자동으로 구매하는 로또 개수 구하는 로직 테스트")
    void autoCountTest(int manualCount, int expected) {
        purchaseInfo = new PurchaseInfo(6000, manualCount);
        assertThat(purchaseInfo.getAutoCount()).isEqualTo(expected);
    }

    private void purchaseInfoValidationException(int amount, int manualCount, String message) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> purchaseInfo = new PurchaseInfo(amount, manualCount))
                .withMessage(message);
    }
}