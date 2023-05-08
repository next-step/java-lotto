package lotto.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    @DisplayName("1등 일치 숫자 개수 확인")
    void matches_first() {
        int expected = 6;
        int actual = Rank.FIRST.matches();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("2등 일치 숫자 개수 확인")
    void matches_second() {
        int expected = 5;
        int actual = Rank.SECOND.matches();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("3등 일치 숫자 개수 확인")
    void matches_third() {
        int expected = 5;
        int actual = Rank.THIRD.matches();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("4등 일치 숫자 개수 확인")
    void matches_fourth() {
        int expected = 4;
        int actual = Rank.FOURTH.matches();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("5등 일치 숫자 개수 확인")
    void matches_fifth() {
        int expected = 3;
        int actual = Rank.FIFTH.matches();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("1등 금액 확인")
    void profit_first() {
        int expected = 2_000_000_000;
        int actual = Rank.FIRST.profit();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("2등 금액 확인")
    void profit_second() {
        int expected = 30_000_000;
        int actual = Rank.SECOND.profit();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("3등 일치 숫자 개수 확인")
    void profit_third() {
        int expected = 1_500_000;
        int actual = Rank.THIRD.profit();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("4등 일치 숫자 개수 확인")
    void profit_fourth() {
        int expected = 50_000;
        int actual = Rank.FOURTH.profit();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("5등 금액 확인")
    void profit_fifth() {
        int expected = 5_000;
        int actual = Rank.FIFTH.profit();

        assertThat(actual).isEqualTo(expected);
    }
}