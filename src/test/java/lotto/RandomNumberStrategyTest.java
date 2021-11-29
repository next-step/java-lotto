package lotto;

import lotto.numberstrategy.RandomLottoNumberStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberStrategyTest {

    @Test
    void create_number_test() {

        RandomLottoNumberStrategy randomNumberStrategy = new RandomLottoNumberStrategy();
        List<Integer> list = randomNumberStrategy.createNumber();

        assertThat(list.size()).isEqualTo(6);
    }
}
