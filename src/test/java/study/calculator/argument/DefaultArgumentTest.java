package study.calculator.argument;

import org.junit.jupiter.api.Test;
import study.calculator.Number;
import study.calculator.StringAddCalculator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DefaultArgumentTest {

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        // When
        DefaultArgument defaultArgument = new DefaultArgument("1");

        // Then
        List<Number> numbers = defaultArgument.parseToNumber();

        assertThat(numbers.size()).isEqualTo(1);
        assertThat(numbers).contains(Number.of("1"));
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        // When
        DefaultArgument defaultArgument = new DefaultArgument("1,2");

        // Then
        List<Number> numbers = defaultArgument.parseToNumber();

        assertThat(numbers.size()).isEqualTo(2);
        assertThat(numbers).contains(Number.of("1"), Number.of("2"));
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        // When
        DefaultArgument defaultArgument = new DefaultArgument("1,2:3");

        // Then
        List<Number> numbers = defaultArgument.parseToNumber();

        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers)
                .contains(Number.of("1"), Number.of("2"), Number.of("3"));
    }

}