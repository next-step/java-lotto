package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

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
}
