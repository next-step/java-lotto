package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.VO.Lottos;
import step4.VO.Money;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottosTest {
    @Test
    @DisplayName("로또 갯수 테스트")
    void lottosCreateTest() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        Money money = new Money(6500);
        Lottos lottos = new Lottos();
        lottos.buyAutoLottos(money, lottoGenerator);

        assertThat(lottos.getLottoList().size()).isEqualTo(6500/Money.lottoPrice);
    }
}
