package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class OperationLinkerTest {

    @ParameterizedTest
    @CsvSource(value = {"1:2:+:3", "2:1:-:1", "2:3:*:6", "6:3:/:2"}, delimiter = ':')
    void plus_link_test(int a, int b, String operator, int expected) {
        int result = OperationLinker.link(a, b, operator);

        assertThat(result).isEqualTo(expected);
    }
}
