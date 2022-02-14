package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName(value = "구매금액에 알맞은 로또의 개수가 생성된다.")
    @Test
    void correctCountGenerator() {
        Lottos lottos = new Lottos(new LottoPrice(10000));
        List<Lotto> lottoLists = lottos.getLottoLists();

        assertThat(lottoLists.size()).isEqualTo(10);
    }

    @DisplayName(value = "구매금액을 로또한개의 가격으로 나누었을때, 나머지가 발생할경우 IllegalArgumentException 발생한다.")
    @Test
    void checkValidPrice() {
        assertThatThrownBy(() -> new Lottos(new LottoPrice(10000)))
        .isInstanceOf(IllegalArgumentException.class);
    }

}
