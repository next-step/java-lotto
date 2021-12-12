package stringcaculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {
    String[] numberArray = {"1", "2", "3"};

    @Test
    @DisplayName("숫자들이 정상적으로 반환되는지 확인합니다.")
    void numbers() {
        Numbers numbers = new Numbers(numberArray);
        List<Number> expectedList = getExpectedList();
        assertThat(numbers.numbers()).isEqualTo(expectedList);
    }

    List<Number> getExpectedList() {
        List<Number> numbers = new ArrayList<>(numberArray.length);
        for (String number : numberArray) {
            numbers.add(new Number(new StringToIntegerValue(number)));
        }
        return numbers;
    }
}