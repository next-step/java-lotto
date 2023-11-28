package step2;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.lotto.domain.Lotto;
import step2.lotto.domain.LottoPurchase;
import step2.lotto.domain.Lottos;

class LottosTest {

    @Test
    @DisplayName("구입정보 : 5장 구매, 1장 수동 4장 자동으로 Lottos를 생성한다.")
    void createLottosTest() {
        LottoPurchase lottoPurchase = new LottoPurchase(5000, List.of("1,2,3,4,5,6"));
        Lottos lottos = Lottos.purchaseLottos(lottoPurchase);

        assertThat(lottos.getLottos()).contains(Lotto.of(Set.of(1,2,3,4,5,6)));
        assertThat(lottos.getLottos()).hasSize(5);
    }

}