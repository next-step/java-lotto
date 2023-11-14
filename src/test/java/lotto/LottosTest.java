package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static lotto.WinningAmount.*;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("로또 일급 컬렉션 테스트")
class LottosTest {

    @DisplayName("입력 받은 수 만큼 로또를 생성한다.")
    @Test
    void generateLottos() {
        Lottos lottos = new Lottos();
        lottos.generate(14);
        Assertions.assertThat(lottos.getNumberOfLotto()).isEqualTo(14);
    }

    @DisplayName("입력된 생성 로또의 숫자가 NULL 또는 0 이하일 때 예외가 발생한다.")
    @Test
    void generateException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Lottos lottos = new Lottos();
            lottos.generate(0);
        });
    }

    @DisplayName("당첨된 로또의 개수를 확인한다.")
    @Test
    void countAllWinningLotto() {
        List<Integer> winningNumber = Arrays.asList(1,2,3,4,5,6);
        Lotto lotto1 = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(Arrays.asList(1,2,3,4,6,6));
        Lotto lotto3 = new Lotto(Arrays.asList(1,2,3,6,6,6));
        Lottos lottos = new Lottos(Arrays.asList(lotto1, lotto2, lotto3));

        WinningLottoManager winningManager = lottos.countAllWinning(winningNumber);
        HashMap<WinningAmount, Integer> winningLottos = winningManager.findWinningLottos();

        Assertions.assertThat(winningLottos.get(SIX_MATCH)).isEqualTo(1);
        Assertions.assertThat(winningLottos.get(FIVE_MATCH)).isEqualTo(1);
        Assertions.assertThat(winningLottos.get(FOUR_MATCH)).isEqualTo(1);
    }
}
