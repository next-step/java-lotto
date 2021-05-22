package lotto;

import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersTest {

    @DisplayName("6개의 숫자로 이루어져있는지 테스트한다")
    @Test
    void check_whether_consists_of_six_numbers() {
        //Given+When
        int[] input = new int[]{1,3,4,6,7,45};

        //When
        WinningNumbers winningNumber = new WinningNumbers(input);

        //Then
        assertThat(winningNumber.count()).isEqualTo(6);
    }

    @DisplayName("중복이 있으면 Exception을 발생한다")
    @Test
    void throw_exception_when_duplicated() {
        //Given+When
        int[] input = new int[]{1,4,4,6,7,45};

        //When+Then
        assertThatThrownBy(() -> new WinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6개 이상의 숫자를 입력하면 Exception을 발생한다")
    @Test
    void throw_exception_when_more_than_six_numbers() {
        //Given+When
        int[] input = new int[]{1,4,4,6,7,8,45};

        //When+Then
        assertThatThrownBy(() -> new WinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈 문자열을 전달하면 Exception을 발생한다")
    @Test
    void throw_exception_when_input_is_empty() {
        //Given+When
        int[] input = new int[]{};

        //When+Then
        assertThatThrownBy(() -> new WinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~45 사이가 아닌 값을 입력하면 Exception을 발생한다")
    @Test
    void throw_exception_when_not_between_1_and_45() {
        //Given+When
        int[] input = new int[]{0,4,4,6,7,46};

        //When+Then
        assertThatThrownBy(() -> new WinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
