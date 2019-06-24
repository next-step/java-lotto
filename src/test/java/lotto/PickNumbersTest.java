package lotto;

import lotto.model.PickNumbers;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PickNumbersTest {

    @Test
    @DisplayName("중복된 숫자 예외처리")
    public void duplicationTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            List<Integer> numbers = Arrays.asList(1, 2, 3, 3, 5, 6);
            new PickNumbers(numbers);
        });
    }

    @Test
    @DisplayName("6개의 숫자가 아닐 경우 예외처리")
    public void lessThanSixNumberExceptionTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new PickNumbers(Arrays.asList(1, 2, 3, 4, 5));
            new PickNumbers(Arrays.asList(1, 2, 3, 4, 5, 7));
        });
    }

    @Test
    @DisplayName("번호 비교")
    public void campareNumbers() {
        PickNumbers lotto1 = new PickNumbers(Arrays.asList(1, 2, 3, 9, 10, 12));
        WinningNumbers lotto2 = new WinningNumbers(Arrays.asList(1, 2, 3, 7, 8, 15));
        assertThat(lotto1.compare(lotto2)).isEqualTo(3);
    }
}
