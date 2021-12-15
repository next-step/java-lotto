package calculator.domain;

import calculator.exception.NumberConstraintViolationException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NumbersTest {
    @DisplayName("Numbers 객체를 생성한다.")
    @Test
    void create() {
        List<Number> numbers = new ArrayList<>(Arrays.asList(new Number("1"), new Number("2"), new Number("3")));
        Assertions.assertThat(new Numbers(numbers)).isInstanceOf(Numbers.class);
    }

    @DisplayName("sum 함수는 List<Number>의 Number를 총 합한 Number를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,6", "2,3,4,9", "3,3,1,7", "4,4,2,10"})
    void sum(String number1, String number2, String number3, String expected) {
        List<Number> numbers = new ArrayList<>(Arrays.asList(new Number(number1), new Number(number2), new Number(number3)));
        assertThat(new Numbers(numbers).sum()).isEqualTo(new Number(expected));
    }
}
