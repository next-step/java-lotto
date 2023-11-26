package lotto;

import lotto.model.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @DisplayName("랭크 valueof 함수 올바른 예시")
    @Test
    void correctValueOf() {
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
    }

    @DisplayName("랭크 valueof 함수 틀린 예시")
    @Test
    void incorrectValueOf() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Rank.valueOf(7, false)).withMessage("맞는 번호의 개수가 맞지 않습니다.");
    }

    @DisplayName("맞힌 개수를 올바르게 갖고온다.")
    @Test
    void countOfMatchTest() {
        assertThat(Rank.FIRST.getCountOfMatch()).isEqualTo(6);
    }

    @DisplayName("등수에 맞는 금액을 호출한다.")
    @Test
    void winningMoneyTest() {
        assertThat(Rank.FIRST.getWinningMoney()).isEqualTo(2_000_000_000);
    }
}
