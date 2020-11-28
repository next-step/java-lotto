package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottosTest {
    @Test
    @DisplayName("로또 갯수 테스트")
    void lottosCreateTest() {
        Generator lottoGenerator = new LottoGenerator();
        lottoGenerator.setNumber("");
        int money = 6500;
        Lottos lottos = new Lottos(money, lottoGenerator);

        assertThat(lottos.lottoList.size()).isEqualTo(money/1000);
    }
}
