package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitUtilTest {

    @ParameterizedTest
    @CsvSource(value = {"1,1", "1:1"}, delimiter = '-')
    void splitExpression(String expression) {
        List<Integer> numbers = SplitUtil.splitExpression(expression);

        assertThat(numbers).hasSize(2);
        assertThat(numbers).containsExactly(1, 1);
    }
}
