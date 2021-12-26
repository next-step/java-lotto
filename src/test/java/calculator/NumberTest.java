package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumberTest {

    @Test
    void createNumber_when_strInput_is_number() {
        // given
        String input = "1";
        Number expectedNumber = new Number(1);

        // when
        Number number = new Number(input);

        // then
        assertThat(number).isEqualTo(expectedNumber);
    }


    @Test
    void createNumber_when_strInput_is_minus_number() {
        // given
        String input = "-1";
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new Number(input)
        );

        //expect
        assertEquals(thrown.getMessage(), "숫자가 아닌 것은 입력할 수 없습니다.");
    }


    @Test
    void createNumber_when_strInput_is_not_a_number() {
        // given
        String input = "12sss12";
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new Number(input)
        );

        //expect
        assertEquals(thrown.getMessage(), "숫자가 아닌 것은 입력할 수 없습니다.");
    }

    @Test
    void plusNumber() {
        // given
        Number number = new Number(1);
        Number otherNumber = new Number(2);
        Number expectedNumber = new Number(3);

        // when
        Number result = number.plus(otherNumber);

        // then
        assertThat(result).isEqualTo(expectedNumber);
    }
}
