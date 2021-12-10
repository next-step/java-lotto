package lotto;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {

    @Test
    void createNumbers_with_String() {
        // given
        String numbersInput = "1, 2, 3, 4, 5, 6";

        // when
        Numbers numbers = new Numbers(numbersInput);

        // then
        assertThat(numbers.getNumbers()).isEqualTo(Lists.list(
                new Number(1),
                new Number(2),
                new Number(3),
                new Number(4),
                new Number(5),
                new Number(6)
        ));
    }

    @Test
    void count_match() {

        // given
        List<Number> numbersList1 = new ArrayList<Number>() {{
            add(new Number(1));
            add(new Number(2));
            add(new Number(3));
            add(new Number(4));
            add(new Number(5));
        }};

        List<Number> numbersList2 = new ArrayList<Number>() {{
            add(new Number(3));
            add(new Number(4));
            add(new Number(5));
            add(new Number(6));
            add(new Number(7));
        }};

        Numbers numbers1 = new Numbers(numbersList1);
        Numbers numbers2 = new Numbers(numbersList2);

        // when
        int matchCount = numbers1.countMatch(numbers2);

        // then
        assertThat(matchCount).isEqualTo(3);
    }
}