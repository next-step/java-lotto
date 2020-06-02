package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeTest {

    @ParameterizedTest
    @CsvSource(value = {"3,5000", "4,50000"})
    @DisplayName("상금 금액을 잘 가져오는지 확인")
    void getPrize(String count, int expected) {
        int result = LottoPrize.getPrize(count);
        assertThat(result).isEqualTo(expected);
    }
}
