package lotto;

import lotto.model.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumbersTest {

    @Test
    @DisplayName("중복된 숫자 예외처리")
    public void duplicationTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            List<Integer> numbers = Arrays.asList(1, 2, 3, 3, 5, 6);
            new LottoNumbers(numbers);
        });
    }

    @Test
    @DisplayName("6개의 숫자가 아닐 경우 예외처리")
    public void lessThanSixNumberExceptionTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5));
            new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 7));
        });
    }
}
