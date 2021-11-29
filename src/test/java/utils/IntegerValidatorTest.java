package utils;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static utils.IntegerValidator.*;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IntegerValidatorTest {

    @Test
    @DisplayName("getNumbersIfRange() 의 범위내 값이 전달될 경우 순서 변경 없이, 동일한 값이 반환되어야 한다.")
    void getNumbersIfRangeTest() {
        assertThat(getNumbersIfRange(Arrays.asList(1, 2, 3), 0, 3)).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("getNumbersIfRange() 의 범위내 값이 아닌경우 예외가 발생한다.")
    void getNumbersIfRangeExceptionTest() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> getNumbersIfRange(Arrays.asList(-1, 2, 3), 0, 3));
    }


    @Test
    @DisplayName("getNumberIfRange() 의 범위내 값이 전달될 경우 동일한 값이 반환되어야 한다.")
    void getNumberIfRangeTest() {
        assertThat(getNumberIfRange(1, 0, 3)).isEqualTo(1);
    }

    @Test
    @DisplayName("getNumberIfRange() 의 범위내 값이 아닌경우 예외가 발생한다.")
    void getNumberIfRangeExceptionTest() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> getNumberIfRange(4, 0, 3));
    }

    @Test
    @DisplayName("getNumberIfPositive() 값이 양수인경우 동일한 값이 반환되어야 한다.")
    void getNumberIfPositiveTest() {
        assertThat(getNumberIfPositive(1)).isEqualTo(1);
    }

    @Test
    @DisplayName("getNumberIfPositive() 값이 양수가 아닌경우 예외가 발생한다.")
    void getNumberIfPositiveExceptionTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> getNumberIfPositive(-1));
    }

}