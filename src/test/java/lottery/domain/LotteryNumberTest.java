package lottery.domain;

import lottery.domain.exception.InvalidLotteryNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class LotteryNumberTest {
    @DisplayName("정상 범위 입력")
    @Test
    void test_validNumber() {
        IntStream.rangeClosed(1, 45).forEach(number -> {
            assertThat(LotteryNumber.valueOf(number))
                    .asString()
                    .isEqualTo(String.valueOf(number));
        });
    }

    @DisplayName("이상 범위 입력")
    @ParameterizedTest
    @ValueSource(ints = { 0, -1, -2, 46, 47, 48 })
    void test_invalidNumber(int number) {
        assertThatExceptionOfType(InvalidLotteryNumberException.class)
                .isThrownBy(() -> LotteryNumber.valueOf(number));
    }

    @DisplayName("reference 비교 검증")
    @ParameterizedTest
    @CsvSource({
            "1,1,true",
            "1,2,false",
            "45,44,false",
            "45,45,true",
    })
    void equality(int left, int right, boolean eq) {
        assertThat( LotteryNumber.valueOf(left) == LotteryNumber.valueOf(right) ).isEqualTo(eq);
    }
}
