package lotto;

import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottosTest {

    @DisplayName("구매 갯수를 전달하면 갯수만큼 로또를 가진 lottos 객체를 생성한다.")
    @Test
    void lottosCreateTest() {
        Lottos lottos = new Lottos(5);
        assertThat(lottos.getSize()).isEqualTo(5);
    }

    @DisplayName("생성된 lottos에 index를 전달하면 해당 위치의 로또를 전달한다.")
    @Test
    void lottosGetLottoTest() {
        Lottos lottos = new Lottos(3);
        assertThat(lottos.getLotto(2).getLotto().size()).isEqualTo(6);
    }
}
