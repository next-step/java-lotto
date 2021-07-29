package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoTest {
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("일치하는 번호의 개수를 반환한다")
    void matchCount() {
        lotto.scratch(WinningNumber.from("1, 2, 3, 4, 5, 6"));
        int matchCount = lotto.matchCount();
        Assertions.assertThat(matchCount).isEqualTo(6);
    }

    @Test
    @DisplayName("로또를 긁기전에는 몇개의 번호가 일치하는지 알 수 없다")
    void matchCountFalse() {
        Assertions.assertThatThrownBy(() -> lotto.matchCount())
                  .isInstanceOf(NullPointerException.class)
                  .hasMessage("you must scratch the lottery ticket first.");
    }

    @Test
    @DisplayName("모든 번호가 일치할때의 당첨금을 반환한다")
    void prize() {
        lotto.scratch(WinningNumber.from("1, 2, 3, 4, 5, 6"));
        int prize = lotto.prize();
        Assertions.assertThat(prize).isEqualTo(2_000_000_000);
    }

    @Test
    @DisplayName("로또를 긁기전에는 당첨금이 얼마인지 알 수 없다")
    void prizeFalse() {
        Assertions.assertThatThrownBy(() -> lotto.prize())
                  .isInstanceOf(NullPointerException.class)
                  .hasMessage("you must scratch the lottery ticket first.");
    }

    @Test
    @DisplayName("투 스트링이 로또 번호를 반환하는지 확인한다")
    void testToString() {
        Assertions.assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
