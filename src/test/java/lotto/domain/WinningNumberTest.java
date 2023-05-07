package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningNumberTest {

    @Test
    @DisplayName(value = "당첨 번호 여섯자리 검사")
    void test1() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            WinningNumber.validNumber(Arrays.asList(1, 2, 3));
        });
    }
}