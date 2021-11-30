package lotto.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CountInfoTest {

    CountInfo countInfo;

    @ParameterizedTest
    @ValueSource(ints = { 2, 3, 4, 6 })
    @DisplayName("자동으로 구매하는 로또 개수 구하는 로직 테스트")
    void autoCountTest(int manualCount) {
        countInfo = new CountInfo(manualCount, 6);
        assertThat(countInfo.getAutoCount()).isEqualTo(6 - manualCount);
    }

    @ParameterizedTest
    @ValueSource(ints = { -1, -2, -3, -4 })
    @DisplayName("manualCount가 0보다 작으면 예외 발생 테스트")
    void manualCountUnderZeroExceptionTest(int manualCount) {
        countInfoValidationException(manualCount, 10, "0보다 큰 숫자를 입력하셔야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = { 2, 3, 4, 5 })
    @DisplayName("manualCount가 구매할 수 있는 로또 개수보다 크면 예외 발생 테스트")
    void manualCountOverLotteryCountExceptionTest(int manualCount) {
        countInfoValidationException( manualCount, 1, "수동으로 구매할 수 있는 로또 수를 넘었습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = { 2, 3, 4, 6 })
    @DisplayName("전체 복권 개수 구하는 로직 테스트")
    void totalCountTest(int manualCount) {
        countInfo = new CountInfo(manualCount, 10);
        assertThat(countInfo.getTotalCount()).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 2, 3, 4 })
    @DisplayName("for loop 돌 때 수동 복권 순서인지 확인 : 수동 복권 개수보다 작은(미만) index의 경우 manual 복권이라 true 반환 테스트")
    void isManualIdxTrueTest(int idx) {
        countInfo = new CountInfo(5, 10);
        assertThat(countInfo.isManualIdx(idx)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(ints = { 5, 6, 7, 8, 9})
    @DisplayName("for loop 돌 때 수동 복권 순서인지 확인 : 수동 복권 개수 이상의 index의 경우 자동 복권이라 false 반환 테스트")
    void isManualIdxFalseTest(int idx) {
        countInfo = new CountInfo(5, 10);
        assertThat(countInfo.isManualIdx(idx)).isEqualTo(false);
    }

    private void countInfoValidationException(int manualCount, int lotteryCount, String message) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> countInfo = new CountInfo(manualCount, lotteryCount))
                .withMessage(message);
    }
}
