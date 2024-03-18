package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {
    @Nested
    @DisplayName("WinningNumbers 인스턴스 생성 테스트")
    class InstanceCreationTest {
        @ParameterizedTest
        @NullAndEmptySource
        @DisplayName("당첨번호가 NULL 또는 공백인 경우 IllegalArgumentException이 발생한다.")
        void testNullOrBlankFailCase(String winningNumbers) {
            assertThatThrownBy(() -> WinningNumbers.valueOf(winningNumbers))
                    .isExactlyInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"1", "1, 2", "1, 2, 3, 4, 5, 6, 7"})
        @DisplayName("당첨 번호가 6개가 아닌 경우 IllegalArgumentException이 발생한다.")
        void testOverMaxFailCase(String winningNumbers) {
            assertThatThrownBy(() -> WinningNumbers.valueOf(winningNumbers))
                    .isExactlyInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"1, 2, 3, a, 5, 6", "1, 2, 3, 4, 5, 44", "0, 2, 3, 4, 5, 6"})
        @DisplayName("당첨 번호가 1보다 크거나 같고 43보다 작거나 같은 정수가 아닌 경우 IllegalArgumentException이 발생한다.")
        void testNonValidNumberFailCase(String winningNumbers) {
            assertThatThrownBy(() -> WinningNumbers.valueOf(winningNumbers))
                    .isExactlyInstanceOf(IllegalArgumentException.class);
        }
    }
}
