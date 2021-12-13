package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumbersTest {

    @Test
    @DisplayName("sum 테스트")
    void sum() {
        List<Number> numberList = Arrays.asList(
                new Number(1),
                new Number(2),
                new Number(3)
        );

        Numbers numbers = new Numbers(numberList);

        Number expectedResult = new Number(6);

        Number result = numbers.sum();

        assertEquals(expectedResult, result);
    }

}
