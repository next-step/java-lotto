package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.LottoFactory;
import step2.domain.Lottos;
import step2.domain.LottosCount;
import step2.util.FixLottoStrategy;
import step2.util.LottoNumberUtils;

import static org.assertj.core.api.Assertions.*;

class LottoFactoryTest {
    @Test
    @DisplayName("금액만큼 로또를 생성한다.")
    void buy() {
        LottoFactory lottoFactory = new LottoFactory(new FixLottoStrategy(LottoNumberUtils.of(1,2,3,4,5,6)));
        LottosCount lottosCount = new LottosCount(3, 10000);
        Lottos lottos = lottoFactory.buy(lottosCount);
        System.out.println(lottosCount.getAuto());
        assertThat(lottos.size()).isEqualTo(7);
    }
}
