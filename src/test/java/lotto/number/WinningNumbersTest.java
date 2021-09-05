package lotto.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {

    @DisplayName("6개로 초기화 된다.")
    @Test
    void createWith6Digits() {
        assertThat(new WinningNumbers(1, 2, 3, 4, 5, 6).value().size()).isEqualTo(LottoNumbers.NUMBERS_LENGTH);
    }

    @DisplayName("1미만 혹은 45초과의 숫자가 포함될 경우 에러 남")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void invokeErrorWhenItsNotBetween1And45(int number) {
        assertThatThrownBy(() -> new WinningNumbers(number, 1, 2, 3, 4, 5)).isInstanceOf(IllegalArgumentException.class);
    }
}
