package autoLotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class NumberTest {
    @Test
    void 숫자_6개미만_입력() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> {
                    List<Integer> numbers = new ArrayList<>();
                    numbers.add(3);
                    numbers.add(6);
                    numbers.add(9);
                    numbers.add(45);

                    new WinningNumbers(numbers);
                }
        );
    }

    @Test
    void 숫자_46_입력() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> {
                    List<Integer> numbers = new ArrayList<>();
                    numbers.add(3);
                    numbers.add(6);
                    numbers.add(9);
                    numbers.add(45);
                    numbers.add(10);
                    numbers.add(51);

                    new WinningNumbers(numbers);
                }
        );
    }
}
