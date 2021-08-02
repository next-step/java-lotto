package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = Lotto.from("1, 2, 3, 4, 5, 6");
    }

    @Test
    @DisplayName("일치하는 번호의 개수를 반환한다")
    void matchCount() {
        LottoPrize lottoPrize = lotto.scratch(WinningLotto.from("1, 2, 3, 4, 5, 6"));
        int prize = lottoPrize.getMatchCount();
        Assertions.assertThat(prize).isEqualTo(6);
    }

    @Test
    @DisplayName("모든 번호가 일치할때의 당첨금을 반환한다")
    void prize() {
        LottoPrize lottoPrize = lotto.scratch(WinningLotto.from("1, 2, 3, 4, 5, 6"));
        int prize = lottoPrize.getPrizeMoney();
        Assertions.assertThat(prize).isEqualTo(2_000_000_000);
    }

    @Test
    @DisplayName("투 스트링이 로또 번호를 반환하는지 확인한다")
    void testToString() {
        Assertions.assertThat(lotto.toString())
                  .startsWith("[")
                  .endsWith("]");
    }
}
