package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinnerNumbersTest {
    @Test
    @DisplayName("WinnerNumbers 객체를 생성할 때 당첨 번호를 ', '로 구분하여 입력하면, 해당 당첨번호를 가진 Set을 반환한다.")
    void testCreateWinnerNumbersWithCommaSeparatedInput() {
        // given
        String input = "10, 12, 30, 34, 40, 45";
        final int inputArrayLength = input.split(", ").length;
        WinnerNumbers winnerNumbers = new WinnerNumbers(input);

        // when
        Set<Integer> nums = winnerNumbers.nums();

        // then
        assertThat(nums)
                .hasSize(inputArrayLength)
                .containsOnly(10, 12, 30, 34, 40, 45);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "10, 12, 30, 34",
            "10, 12, 30, 34, 45",
            "10, 12, 30, 34, 40, 47",
            "10, 12, 30, 34, 40, -1",
            "10, 12, 30, 34, 40, 49, 50"
    })
    @DisplayName("WinnerNumbers 객체를 생성할 때 입력 번호로 1 ~ 45까지의 수를 중복되지 않게 6개를 입력하지 않으면, IllegalArgumentException 예외가 발생한다.")
    void testWinnerNumbersHasUniqueSixNumbers(final String userInput) {
        //given, when, then
        assertThatThrownBy(() -> new WinnerNumbers(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
