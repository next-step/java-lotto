package lottery.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class LotteryNumberTest {
    @Test
    void test_validNumber() {
        IntStream.rangeClosed(1, 45).forEach(number -> {
            assertThat(new LotteryNumber(number))
                    .asString()
                    .isEqualTo(String.valueOf(number));
        });
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, -1, -2, 46, 47, 48 })
    void test_invalidNumber(int number) {
        assertThatExceptionOfType(InvalidLotteryNumberException.class)
                .isThrownBy(() -> new LotteryNumber(number));
    }
}
