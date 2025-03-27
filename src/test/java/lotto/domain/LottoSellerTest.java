package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoSellerTest {
    private final static int PRICE = 1000;

    @DisplayName("로또 판매점을 생성할 수 있다.")
    @Test
    void createTest() {
        // given
        int money = 14000;

        // when
        LottoSeller lottoSeller = new LottoSeller(money);

        // then
        assertThat(lottoSeller).isNotNull();
    }

    @DisplayName("로또보다 돈이 모자른 경우 예외가 발생한다.")
    @Test
    void checkMoneyTest() {
        int money = 999;

        assertThatIllegalArgumentException().isThrownBy(() -> new LottoSeller(money))
                .withMessage("money is less than " + PRICE);
    }

    @DisplayName("입력받은 금액에 해당하는 로또를 생성한다.")
    @Test
    void generateLottosTest() {
        // given
        LottoSeller lottoSeller = new LottoSeller(10000);

        // when
        List<Lotto> lottos = lottoSeller.generateLottos(new AutomaticStrategy());

        // then
        assertThat(lottos).hasSize(10);
    }

}
