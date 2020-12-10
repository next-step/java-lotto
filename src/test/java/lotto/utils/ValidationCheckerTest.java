package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationCheckerTest {

    @Test
    @DisplayName("널 체크트 테스트")
    void nullTest() {
        assertThatThrownBy(() -> ValidationChecker.isEmptyOrNull(null))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("공백 체크 테스")
    void emptyTest() {
        assertThatThrownBy(() -> ValidationChecker.isEmptyOrNull(""))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("음수 입력 테스트")
    void minusTest() {
        assertThatThrownBy(() -> ValidationChecker.exceptionCheck("-1"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("문자 입력 테스트")
    void charTest() {
        assertThatThrownBy(() -> ValidationChecker.exceptionCheck("e"))
                .isInstanceOf(RuntimeException.class);
    }
    @Test
    @DisplayName("범위 초과 테스트 1 미만")
    void underOne() {
        assertThatThrownBy(() -> ValidationChecker.checkValidNumber(Arrays.asList(0,2,3,4,5,6)))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("범위 초과 테스트 45 초과")
    void overFourtyFive() {
        assertThatThrownBy(() -> ValidationChecker.checkValidNumber(Arrays.asList(0,2,3,48,5,6)))
                .isInstanceOf(RuntimeException.class);
    }

}
