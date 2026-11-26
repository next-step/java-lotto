package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {

    @DisplayName("일치 개수가 0~2개면 꽝 (0, 2 → 꽝)")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    public void test_1(int matchCount) {
        Prize prize = Prize.from(matchCount);
        assertThat(prize).isEqualTo(Prize.NONE);
        assertThat(prize.getMoney()).isEqualTo(0);
    }

    @DisplayName("일치 개수가 3~6개면 해당 상금에 당첨된다.")
    @ParameterizedTest(name = "일치 개수가 {0}개면 {2}원 당첨")
    @CsvSource({
            "3, THREE, 5000",
            "4, FOUR, 50000",
            "5, FIVE, 1500000",
            "6, SIX, 2000000000"
    })
    public void test_2(int matchCount, Prize expected, int money) {
        Prize prize = Prize.from(matchCount);
        assertThat(prize).isEqualTo(expected);
        assertThat(prize.getMoney()).isEqualTo(money);
    }
}
