package autoLotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class NumberTest {
    @Test
    void 숫자_6개미만_입력() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> {
                    List<Integer> numbers = Arrays.asList(new Integer[]{3, 6, 9, 45, 10});
                    new WinningNumbers(numbers, 1);
                }
        );
    }

    @Test
    void 숫자_6개초과_입력() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> {
                    List<Integer> numbers = Arrays.asList(new Integer[]{3, 6, 9, 45, 10, 11, 12});
                    new WinningNumbers(numbers, 1);
                }
        );
    }

    @Test
    void 숫자_46이상_입력() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> {
                    List<Integer> numbers = Arrays.asList(new Integer[]{3, 6, 9, 45, 10, 51});
                    new WinningNumbers(numbers, 1);
                }
        );
    }

    @Test
    void 보너스볼_46이상_입력() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> {
                    List<Integer> numbers = Arrays.asList(new Integer[]{3, 6, 9, 45, 10,11});
                    new WinningNumbers(numbers, 46);
                }
        );
    }

    @Test
    void 당첨번호_입력_성공() {
        List<Integer> numbers = Arrays.asList(new Integer[]{3, 6, 9, 45, 10, 11});
        WinningNumbers winningNumbers = new WinningNumbers(numbers, 1);

        assertThat(winningNumbers.getWinningNumbers()).containsExactly(3,6,9,45,10,11);
    }
}
