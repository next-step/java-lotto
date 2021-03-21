package lotto.step1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {

    @DisplayName("Numbers 총합 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,6", "4,5,6,15", "5,10,15,30"}, delimiter = ',')
    void getSum(int inputNumber1, int inputNumber2, int inputNumber3, int expected) {
        Number number1 = Number.of(inputNumber1);
        Number number2 = Number.of(inputNumber2);
        Number number3 = Number.of(inputNumber3);

        List<Number> numberList = new ArrayList<>();
        numberList.add(number1);
        numberList.add(number2);
        numberList.add(number3);
        Numbers numbers = Numbers.of(numberList);

        assertThat(numbers.getSum()).isEqualTo(Number.of(expected));
    }
}
