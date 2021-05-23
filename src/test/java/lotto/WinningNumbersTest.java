package lotto;

import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersTest {

    @DisplayName("중복이 있으면 Exception을 발생한다")
    @Test
    void throw_exception_when_duplicated() {
        //Given+When
        int[] input = new int[]{1,2,2,2,2,3};

        //When+Then
        assertThatThrownBy(() -> new WinningNumbers(input))
                .isInstanceOf(CustomIllegalArgumentException.class);
    }

    @DisplayName("6개 초과의 숫자를 입력하면 Exception을 발생한다")
    @Test
    void throw_exception_when_more_than_six_numbers() {
        //Given+When
        int[] input = new int[]{1,2,3,4,5,6,7};

        //When+Then
        assertThatThrownBy(() -> new WinningNumbers(input))
                .isInstanceOf(CustomIllegalArgumentException.class);
    }

    @DisplayName("6개 미만의 숫자를 입력하면 Exception을 발생한다")
    @Test
    void throw_exception_when_less_than_six_numbers() {
        //Given+When
        int[] input = new int[]{1,2,3,4,5};

        //When+Then
        assertThatThrownBy(() -> new WinningNumbers(input))
                .isInstanceOf(CustomIllegalArgumentException.class);
    }

    @DisplayName("빈 문자열을 전달하면 Exception을 발생한다")
    @Test
    void throw_exception_when_input_is_empty() {
        //Given+When
        int[] input = new int[]{};

        //When+Then
        assertThatThrownBy(() -> new WinningNumbers(input))
                .isInstanceOf(CustomIllegalArgumentException.class);
    }
}
