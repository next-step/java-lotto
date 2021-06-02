package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static lotto.domain.LottoPrize.*;

class LottosTest {

    @DisplayName("특정 숫자 만큼 로또 무작위로 생성")
    @Test
    void createLottos() {
        List<Lotto> lottos = new Lottos(10).getLottos();
        assertThat(lottos).hasSize(10);
        assertThat(lottos).doesNotHaveDuplicates();
    }

    @DisplayName("당첨금 총액 구하기")
    @Test
    void getWinningResult() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7))
        ));
        lottos.updateLottoResult(winningLotto);
        long firstPrize = FIRST.getWinningPrize();
        long thridPrize = THIRD.getWinningPrize();
        assertThat(firstPrize).isEqualTo(FIRST.matchPrize);
        assertThat(firstPrize + thridPrize).isEqualTo(getTotalPrize());
    }

}