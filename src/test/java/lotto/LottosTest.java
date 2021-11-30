package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.RandomLottoNumberStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottosTest {

    @Test
    void lotto_금액_exception_test() {

        assertThatThrownBy(() -> Lottos.getLottoCount(2200)).isInstanceOf(IllegalArgumentException.class);
        assertThat(Lottos.getLottoCount(2000)).isEqualTo(2);

    }


    @Test
    @DisplayName("lottos create 결과 체크")
    void create_lottos_test() {
        int lottoCount = 9;
        Lottos lottos = Lottos.createLottos(lottoCount, new RandomLottoNumberStrategy());

        List<Lotto> lottoList = lottos.getLottos();

        assertThat(lottoList.size()).isEqualTo(lottoCount);
    }

}
