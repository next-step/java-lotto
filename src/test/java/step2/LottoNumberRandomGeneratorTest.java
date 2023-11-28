package step2;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.lotto.domain.LottoPurchase;
import step2.lotto.strategy.LottoNumberRandomGenerator;

class LottoNumberRandomGeneratorTest {

    @Test
    @DisplayName("로또 번호를 랜덤으로 생성한 로또를 생성한다.")
    void lottoNumbersCreateTest() {
        LottoPurchase lottoPurchase = new LottoPurchase(1000);
        assertThat(new LottoNumberRandomGenerator().generateLottos(lottoPurchase)).hasSize(1);
    }
}
