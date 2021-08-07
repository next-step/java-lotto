package lotto.model;

import lotto.prize.LottoPrize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottosTest {
    private Lottos lottos;

    @BeforeEach
    void setUp() {
        lottos = Lottos.from(List.of(
                Lotto.from("1, 2, 3, 4, 5, 6"),
                Lotto.from("1, 2, 3, 4, 5, 6"),
                Lotto.from("1, 2, 3, 4, 5, 6"))
        );
    }

    @Test
    @DisplayName("가지고 있는 로또를 모두 긁고 결과를 반환한다. 총 당첨금은 15,000원이다")
    void scratch() {
        WinningLotto winningLotto = WinningLotto.from("1, 2, 3, 7, 8, 9", "4");
        Assertions.assertThat(winningLotto.matchResults(lottos).stream()
                                          .map(LottoPrize::getPrizeMoney)
                                          .reduce(Money.ZERO, Money::addition))
                  .isEqualTo(Money.from(15_000));
    }

    @Test
    @DisplayName("투 스트링이 로또 번호를 반환하는지 확인한다")
    void testToString() {
        Assertions.assertThat(lottos.toString())
                  .startsWith("[")
                  .endsWith(System.lineSeparator());
    }
}
