package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName(value = "구매금액에 알맞은 로또의 개수가 생성된다.")
    @Test
    void correctCountGenerator() {
        Lottos lottos = new Lottos(new LottoPrice(10000),
            Arrays.asList("1, 2, 3, 4, 5, 6", "7, 8, 9, 10, 11, 12"));
        List<Lotto> lottoLists = lottos.getLottos();

        assertThat(lottoLists.size()).isEqualTo(10);
    }

    @DisplayName(value = "구매금액을 로또한개의 가격으로 나누었을때, 나머지가 발생할경우 IllegalArgumentException 발생한다.")
    @Test
    void checkValidPrice() {
        assertThatThrownBy(() -> new Lottos(new LottoPrice(10100),
            Arrays.asList("1, 2, 3, 4, 5, 6", "7, 8, 9, 10, 11, 12")))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "수동 로또가 있으면 로또 객체에 추가된다")
    @Test
    void addManualLotto() {
        Lottos lottos = new Lottos(new LottoPrice(10000),
            Arrays.asList("1, 2, 3, 4, 5, 6", "7, 8, 9, 10, 11, 12"));
        assertThat(lottos.getLottos().contains(new Lotto(new HashSet<>(
            Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)))))).isTrue();
    }
}
