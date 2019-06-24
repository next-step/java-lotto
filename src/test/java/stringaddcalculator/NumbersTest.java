package stringaddcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NumbersTest {

    @Test
    @DisplayName("총 합을 정상적으로 구하는지 확인한다")
    void checkSum() {
        // given
        Numbers numbers = Numbers.of(Arrays.asList(0,1,2,3,4));
        // when
        int result = numbers.sum();
        // then
        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("입력값에 음수가 존재하는경우 예외처리를 확인한다")
    void checkNegative() {
        assertThatIllegalArgumentException()
                // when
                .isThrownBy(() -> {
                    Numbers.of(Arrays.asList(-1,0,1,2,3));
                // then
                }).withMessageMatching("Number is negative");
    }
}
