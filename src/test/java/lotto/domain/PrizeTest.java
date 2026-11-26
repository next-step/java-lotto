package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class PrizeTest {
    @DisplayName("일치 개수에 해당하는 상금을 찾는다")
    @ParameterizedTest(name = "{0}개 일치면 {1}원")
    @CsvSource(value = {"6:2000000000", "5:1500000", "4:50000", "3:5000"}, delimiter = ':')
    void fromCount(int count, int money) {
        Prize prize = Prize.fromCount(count);
        assertThat(prize.getMoney()).isEqualTo(money);
    }

    @DisplayName("3개 미만이면 당첨되지 않는다")
    @ParameterizedTest(name = "{0}개 일치")
    @ValueSource(ints = {0, 1, 2})
    void noPrize(int count) {
        Prize prize = Prize.fromCount(count);
        assertThat(prize).isEqualTo(Prize.NONE);
    }
}
