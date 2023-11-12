package lotto.domain;

import lotto.domain.strategy.RandomLottoNumberStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    void 로또들을_생성_할_수_있다() {
        Lottos actual = new Lottos(new RandomLottoNumberStrategy() {
            @Override
            protected List<Integer> createRandomNumbers() {
                return List.of(1, 2, 3, 4, 5, 6);
            }
        }, 1);
        Lottos expected = new Lottos(List.of("1, 2, 3, 4, 5, 6"));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 로또들로_로또들을_생성_할_수_있다() {
        Lottos actual = new Lottos(new Lottos(List.of("1, 2, 3, 4, 5, 6")), new Lottos(List.of("1, 2, 3, 4, 5, 6")));
        Lottos expected = new Lottos(List.of("1, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5, 6"));

        assertThat(actual).isEqualTo(expected);
    }
}
