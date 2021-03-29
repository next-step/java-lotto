package step01Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step01.Validation;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {

    @Test
    @DisplayName("리턴 값을 0로 판단하는 테스트")
    void returnZero() {
        assertThat(Validation.isNumberZeroOrEmpty(Arrays.asList("0",""))).isEqualTo(true);
        assertThat(Validation.isNumberZeroOrEmpty(Collections.singletonList("1"))).isEqualTo(false);
    }

    @Test
    @DisplayName("음수를 입력했을 때 RuntimeException 테스트")
    void sumNegativeRuntimeException() {
        assertThatThrownBy(() ->
                Validation.checkIsNegative(Collections.singletonList("-1")))
                .isInstanceOf(RuntimeException.class);
    }
}
