package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumbersTest {


    @Test
    @DisplayName("중복된 숫자 예외처리")
    public void duplicationTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            List<Integer> numbers = Arrays.asList(1, 2, 3, 3, 5, 6);
            new WinningNumbers(numbers);
        });
    }

    @Test
    @DisplayName("범위를 넘어서 숫자 예외처리")
    public void rangeException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            List<Integer> numbers = Arrays.asList(1, 50, 3, 3, 5, 6);
            new WinningNumbers(numbers);
        });
    }

    @Test
    @DisplayName("6개의 숫자가 아닐 경우 예외처리")
    public void lessThanSixNumberExceptionTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5));
            new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 7));
        });
    }

    @Test
    @DisplayName("당첨 번호에 포함되어 있는 경우")
    void contains() {
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(winningNumbers.contains(3)).isTrue();
    }

    @Test
    @DisplayName("당첨 번호에 포함되어 있지 않는 경우")
    void notContains() {
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(winningNumbers.contains(10)).isFalse();
    }
}