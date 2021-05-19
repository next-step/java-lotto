package stringCalculator.number;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositiveTest {
    @Test
    @DisplayName("음수가 들어올 경우 에러")
    void throwErrorNegative() {
        //given
        //when
        //then
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new Positive("-1")).withMessageContaining("음수");
    }

    @Test
    @DisplayName("덧셈")
    void testSum() {
        //given
        Positive positive1 = new Positive("1");
        Positive positive2 = new Positive("2");
        //when
        int result = positive1.getValue() + positive2.getValue();
        //then
        assertThat(result).isEqualTo(3);
    }
}