package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 5, 10, 100})
    void when_CallingGetter_Expects_ReturnRightNumber(int expected) {
        // given
        Result result = new Result(expected);

        // when
        int actual = result.get();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"PLUS, 2", "MINUS, 2", "MULTIPLY, 2", "DIVIDE, 2"})
    void operations(Operations operations, int num) {
        // given
        Result result = new Result(10);

        // when
        result.apply(operations, num);

        // then
        int expected = operations.apply(10, num);
        assertThat(result.get()).isEqualTo(expected);
    }
}