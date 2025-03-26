package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lottos;
import step2.util.FixLottoStrategy;
import step2.util.LottoStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.util.LottoNumberUtils.of;

class LottosTest {
    @Test
    void buyLottos() {
        int count = Lottos.countLottoByAmount(3000);
        assertThat(count).isEqualTo(3);
    }

    @Test
    @DisplayName("로또들을 생성한다")
    void generateLottos() {
        LottoStrategy lottoStrategy = new FixLottoStrategy(of(1,3,4,5,6,7));
        Lottos lottos = Lottos.generateLottos(3, lottoStrategy);
        System.out.println();
        assertThat(lottos.size()).isEqualTo(3);
    }
}
