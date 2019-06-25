package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PositiveNumbersTest {
    @Test
    @DisplayName("주어진 String List 로 생성된다")
    void constructor() {
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        PositiveNumber positiveNumber1 = new PositiveNumber(1);
        PositiveNumber positiveNumber2 = new PositiveNumber(2);
        PositiveNumber positiveNumber3 = new PositiveNumber(3);

        PositiveNumbers positiveNumbers = new PositiveNumbers(strings);

        assertThat(positiveNumbers.getPositiveNumbers())
                .contains(positiveNumber1, positiveNumber2, positiveNumber3);
    }
}
