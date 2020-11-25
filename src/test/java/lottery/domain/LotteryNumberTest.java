package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class LotteryNumberTest {
    @DisplayName("정상 범위 입력")
    @Test
    void test_validNumber() {
        IntStream.rangeClosed(1, 45).forEach(number -> {
            assertThat(new LotteryNumber(number))
                    .asString()
                    .isEqualTo(String.valueOf(number));
        });
    }

    @DisplayName("이상 범위 입력")
    @ParameterizedTest
    @ValueSource(ints = { 0, -1, -2, 46, 47, 48 })
    void test_invalidNumber(int number) {
        assertThatExceptionOfType(InvalidLotteryNumberException.class)
                .isThrownBy(() -> new LotteryNumber(number));
    }
}
