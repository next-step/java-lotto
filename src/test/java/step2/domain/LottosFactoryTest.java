package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottosFactoryTest {

    @DisplayName("LottoNumbers 한 개는 1000원이고, 구입 금액에 따라 로또 번호들을 생성한다.")
    @Test
    void buyWithMoney(){
        Lottos lottos = LottosFactory.buyWithMoney(14000);
        assertThat(lottos.size()).isEqualTo(14);
    }

}