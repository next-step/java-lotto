package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    Lotto lotto;

    @BeforeEach
    void setUp(){
        lotto = new Lotto();
    }

    @DisplayName("로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.")
    @Test
    void buyLottoTest(){
        assertThat(lotto.buyLotto(14000)).isEqualTo(14);
    }

    @DisplayName("로또 공은 1~45까지이다.")
    @Test
    void createLottoBallTest(){

        assertThat(lotto.createLottoBall().get(0)).isBetween(1,45);
    }
}
