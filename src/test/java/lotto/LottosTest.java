package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottosTest {

    @Test
    void createLottos() {
        // given
        List<Lotto> lottoList = lottos(4);

        // when
        Lottos lottos = new Lottos(lottoList);

        // then
        assertThat(lottos.getLottos().size()).isEqualTo(4);
    }

    @Test
    void buyLotto_count() {
        // given
        List<Lotto> lottoList = lottos(5);

        // when
        Lottos lottos = new Lottos(lottoList);

        // then
        assertThat(lottos.count()).isEqualTo(5);
    }

    @Test
    void calculateMatchCount() {
        // given
        Lotto winnerLotto = new Lotto("4, 5, 6, 7, 8, 9");
        Lottos lottos = new Lottos(lottos(4));

        // when

    }

    List<Lotto> lottos(int count) {
        Numbers numbers = new Numbers("1, 2, 3, 4, 5, 6");
        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0; i < count; i++) {
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }

}
