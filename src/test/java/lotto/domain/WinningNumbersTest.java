package lotto.domain;

import lotto.domain.lotto.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

class WinningNumbersTest {
    @Nested
    @DisplayName("WinningNumbers 인스턴스 생성 테스트")
    @TestInstance(PER_CLASS)
    class InstanceCreationTest {
        @ParameterizedTest
        @NullAndEmptySource
        @DisplayName("당첨 번호가 NULL 또는 공백인 경우 IllegalArgumentException이 발생한다.")
        void testNullOrBlankFailCase(String winningNumberInput) {
            assertThatThrownBy(() -> WinningNumbers.valueOf(winningNumberInput))
                    .isExactlyInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"1", "1, 2", "1, 2, 3, 4, 5, 6, 7"})
        @DisplayName("당첨 번호의 숫자 개수가 LOTTO_NUMBER_COUNT가 아닌 경우 IllegalArgumentException이 발생한다.")
        void testOverMaxFailCase(String winningNumberInput) {
            assertThatThrownBy(() -> WinningNumbers.valueOf(winningNumberInput))
                    .isExactlyInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"1, 2, 3, a, 5, 6", "1, 2, 3, 4, 5, 6.123"})
        @DisplayName("당첨 번호의 숫자가 정수가 아닌 경우 IllegalArgumentException이 발생한다.")
        void testNonValidNumberFailCase(String winningNumberInput) {
            assertThatThrownBy(() -> WinningNumbers.valueOf(winningNumberInput))
                    .isExactlyInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("당첨 번호에 중복된 숫자가 있는 경우 IllegalArgumentException이 발생한다.")
        void testDuplicateNumberFailCase() {
            String duplicateWinningNumbers = "1, 2, 3, 3, 5, 6";

            assertThatThrownBy(() -> WinningNumbers.valueOf(duplicateWinningNumbers))
                    .isExactlyInstanceOf(IllegalArgumentException.class);
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4, 5, 6:4:true", "1, 2, 3, 4, 5, 6:7:false"}, delimiter = ':')
    @DisplayName("contains(): 당첨 번호에 number가 포함되어 있다면 true를 없다면 false를 반환한다.")
    void testContains(String winningNumberInput, int lottoNumber, boolean expected) {
        WinningNumbers winningNumbers = WinningNumbers.valueOf(winningNumberInput);
        assertThat(winningNumbers.contains(LottoNumber.valueOf(lottoNumber))).isEqualTo(expected);
    }
}
