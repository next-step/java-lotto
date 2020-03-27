package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}