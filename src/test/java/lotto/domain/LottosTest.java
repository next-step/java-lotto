package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static lotto.domain.WinningAmount.*;

@DisplayName("로또 일급 컬렉션 테스트")
class LottosTest {

    @DisplayName("당첨된 로또의 개수를 확인한다.")
    @Test
    void countAllWinningLotto() {
        List<Integer> winningNumber = List.of(1,2,3,4,5,6);
        Lotto lotto1 = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(List.of(10,2,3,4,5,6));
        Lotto lotto3 = new Lotto(List.of(10,11,3,4,5,6));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3), winningNumber);

        HashMap<WinningAmount, Integer> result = lottos.countAllWinning();
        Assertions.assertThat(result.get(FOUR_MATCH)).isEqualTo(1);
        Assertions.assertThat(result.get(FIVE_MATCH)).isEqualTo(1);
        Assertions.assertThat(result.get(SIX_MATCH)).isEqualTo(1);
    }

    @DisplayName("보너스 번호에 따른 로또를 확인한다.")
    @Test
    void findLottoHasBonus() {
        List<Integer> winningNumber = List.of(1,2,3,4,5,6);
        Lotto lotto = new Lotto(List.of(1,2,3,4,10,11));
        Lottos lottos = new Lottos(List.of(lotto), winningNumber, 5);

        HashMap<WinningAmount, Integer> result = lottos.countAllWinning();
        Assertions.assertThat(result.get(FIVE_MATCH_AND_BONUS)).isEqualTo(1);
    }
}
