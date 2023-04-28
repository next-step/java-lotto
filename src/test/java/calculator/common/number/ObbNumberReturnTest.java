package calculator.common.number;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ObbNumberReturnTest {

    private static final int MINIMUM_EVEN_NUMBER = 2;

    @ParameterizedTest(name = "홀수를 2로 나눈 값을 반 내림 하여 반환한다. ex) {0} / 2 -> {1}")
    @CsvSource(value = {"7:3", "1:0"}, delimiter = ':')
    void oddNumberReturnTest(int numerator, int expect) {
        assertThat(numerator / MINIMUM_EVEN_NUMBER).isEqualTo(expect);
    }

}
