package lotto.domain;

import lotto.domain.strategy.RandomLottoNumberStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    void 입력된_금액으로_로또_기계가_생성된다() {
        RandomLottoNumberStrategy randomLottoNumberStrategy = new RandomLottoNumberStrategy() {
            @Override
            protected List<Integer> createRandomNumbers() {
                return List.of(1, 2, 3, 4, 5, 6);
            }
        };

        LottoMachine actual = new LottoMachine(randomLottoNumberStrategy, new BuyingAmount(1000));
        LottoMachine expected = new LottoMachine(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));

        assertThat(actual).isEqualTo(expected);
    }

}
