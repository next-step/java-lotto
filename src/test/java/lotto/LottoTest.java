package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    @DisplayName("6개의 숫자로 구성되지 않은 숫자 리스트를 입력받으면 예외를 반환한다.")
    @Test
    void validateSizeTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(Arrays.asList(1, 2, 3, 4, 5));
        });
    }

    @DisplayName("중복된 숫자가 포함된 숫자 리스트를 입력받으면, 예외를 반환한다.")
    @Test
    void validateDuplicationTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(Arrays.asList(1, 1, 2, 3, 4, 5));
        });
    }

    @DisplayName("로또는 1 이상, 45 이하의 숫자로만 구성되어야 한다. 그렇지 않을 경우, 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void validateNumberRangeTest(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(Arrays.asList(input, 1, 2, 3, 4, 5));
        });
    }
}