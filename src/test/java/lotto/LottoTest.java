package lotto;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoTest {

    @DisplayName("로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.")
    @Test
    void buyLottoTest() {
        Lotto lotto = new Lotto();
        int money = 14000;
        assertThat(lotto.buyLotto(money)).isEqualTo(14);
    }




}
