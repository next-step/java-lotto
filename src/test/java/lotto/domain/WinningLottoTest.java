package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static lotto.domain.WinningAmount.FIVE_MATCH_AND_BONUS;

@DisplayName("당첨 로또 찾기 테스트")
public class WinningLottoTest {

    @DisplayName("5개의 당첨 번호와 보너스 볼이 일치한 로또 번호를 찾는다.")
    @Test
    void findSecondWinningLotto() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,7));
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
        WinningLotto winningLottoObject = new WinningLotto(winningLotto, 7);
        winningLottoObject.countWinning(lotto);

        HashMap<WinningAmount, Integer> result = winningLottoObject.sortWinningLottos();
        Assertions.assertThat(result.get(FIVE_MATCH_AND_BONUS)).isEqualTo(1);
    }
}
