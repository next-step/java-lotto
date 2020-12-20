package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    @DisplayName("로또 생성")
    void testCreateLottos() {
        Lottos lottos = new Lottos();
        assertThat(lottos.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동 번호 선택")
    void testFillAutoRemaining() {
        // given
        int size = 14;
        // when
        Lottos lottos = new Lottos();
        lottos.addAuto(size);
        // then
        assertThat(lottos.size()).isEqualTo(size);
    }

    @Test
    @DisplayName("로또 당첨 결과")
    void testLottoResult() {
        // given
        Lottos lottos = new Lottos();
        lottos.add(Lotto.of("1,2,3,4,5,6"));
        WinningLotto winningLotto = new WinningLotto(Lotto.of("1,2,3,14,15,16"));
        // when
        LottoResult result = lottos.getLottoResult(winningLotto);
        // then
        assertThat(result.calculateYield()).isEqualTo(5.0);

    }
}
