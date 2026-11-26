package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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

    @DisplayName("일치 개수가 3개면 5000원 당첨")
    @Test
    public void test_2() {
        Prize prize = Prize.from(3);
        assertThat(prize).isEqualTo(Prize.THREE);
        assertThat(prize.getMoney()).isEqualTo(5_000);
    }

    @DisplayName("일치 개수가 4개면 50000원 당첨")
    @Test
    public void test_3() {
        Prize prize = Prize.from(4);
        assertThat(prize).isEqualTo(Prize.FOUR);
        assertThat(prize.getMoney()).isEqualTo(50_000);
    }

    @DisplayName("일치 개수가 5개면 1500000원 당첨")
    @Test
    public void test_4() {
        Prize prize = Prize.from(5);
        assertThat(prize).isEqualTo(Prize.FIVE);
        assertThat(prize.getMoney()).isEqualTo(1_500_000);
    }

    @DisplayName("일치 개수가 6개면 2000000000원 당첨")
    @Test
    public void test_5() {
        Prize prize = Prize.from(6);
        assertThat(prize).isEqualTo(Prize.SIX);
        assertThat(prize.getMoney()).isEqualTo(2_000_000_000);
    }
}
