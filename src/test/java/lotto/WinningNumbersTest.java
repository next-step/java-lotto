package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.WinningNumbers;
import lotto.exception.CustomIllegalArgumentException;
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
        assertThatThrownBy(() -> new WinningNumbers(input, 6))
                .isInstanceOf(CustomIllegalArgumentException.class);
    }

    @DisplayName("6개 초과의 당첨번호를 입력하면 Exception을 발생한다")
    @Test
    void throw_exception_when_more_than_six_numbers() {
        //Given+When
        int[] input = new int[]{1,2,3,4,5,6,7};

        //When+Then
        assertThatThrownBy(() -> new WinningNumbers(input, 8))
                .isInstanceOf(CustomIllegalArgumentException.class);
    }

    @DisplayName("6개 미만의 당첨번호를 입력하면 Exception을 발생한다")
    @Test
    void throw_exception_when_less_than_six_numbers() {
        //Given+When
        int[] input = new int[]{1,2,3,4,5};

        //When+Then
        assertThatThrownBy(() -> new WinningNumbers(input, 6))
                .isInstanceOf(CustomIllegalArgumentException.class);
    }

    @DisplayName("빈 문자열을 전달하면 Exception을 발생한다")
    @Test
    void throw_exception_when_input_is_empty() {
        //Given+When
        int[] input = new int[]{};

        //When+Then
        assertThatThrownBy(() -> new WinningNumbers(input, 1))
                .isInstanceOf(CustomIllegalArgumentException.class);
    }

    @DisplayName("6개의 당첨번호 입력 후, 중복된 보너스 번호를 입력하면 Exception을 발생한다")
    @Test
    void throw_exception_when_duplicated_bonus_number() {
        //Given+When
        int[] input = new int[]{1,2,3,4,5,6};

        //Then
        assertThatThrownBy(() -> new WinningNumbers(input,1))
                .isInstanceOf(CustomIllegalArgumentException.class);
    }

}
