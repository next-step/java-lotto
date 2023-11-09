package lotto.domain.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class RandomLottoNumberStrategyTest {

    @Test
    void 숫자_6개가_생성된다() {
        RandomLottoNumberStrategy randomLottoNumberStrategy = new RandomLottoNumberStrategy() {
            @Override
            protected List<Integer> createRandomNumbers() {
                return List.of(1, 2, 3, 4, 5, 6);
            }
        };

        List<Integer> actual = randomLottoNumberStrategy.create();
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);

        assertThat(actual).isEqualTo(expected);
    }
}
