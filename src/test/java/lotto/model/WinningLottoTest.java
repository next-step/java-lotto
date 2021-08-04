package lotto.model;

import lotto.prize.LottoPrize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class WinningLottoTest {
    @Test
    @DisplayName("로또번호와 보너스번호가 중복되는 경우 예외를 발생시킨다")
    void constructor() throws Exception {
        Assertions.assertThatThrownBy(() -> WinningLotto.from("1, 2, 3, 4, 5, 6", "2"))
                  .isInstanceOf(IllegalArgumentException.class)
                  .hasMessage("the lotto number and the bonus number overlap.");
    }

    @Test
    @DisplayName("로또 번호에 보너스 번호가 존재한다면 참을 반환한다")
    void isMatchBonus() {
        Lotto lotto = Lotto.from("1, 2, 3, 4, 5, 7");
        WinningLotto winningLotto = WinningLotto.from("1, 2, 3, 4, 5, 6", "7");
        Assertions.assertThat(winningLotto.isMatchBonus(lotto)).isTrue();
    }

    @Test
    @DisplayName("로또뭉치를 입력받아 각 로또의 당첨금을 반환한다")
    void matchResults() throws Exception {
        Lottos lottos = Lottos.from(List.of(
                Lotto.from("1, 2, 3, 4, 5, 6"),
                Lotto.from("1, 2, 3, 7, 5, 6"),
                Lotto.from("1, 2, 3, 7, 8, 6"))
        );
        WinningLotto winningLotto = WinningLotto.from("1, 2, 3, 7, 8, 9", "10");
        List<LottoPrize> lottoPrizes = winningLotto.matchResults(lottos);

        Assertions.assertThat(lottoPrizes.size()).isEqualTo(3);
        Assertions.assertThat(lottoPrizes).containsExactly(LottoPrize.FIFTH, LottoPrize.FOURTH, LottoPrize.THIRD);
    }
}
