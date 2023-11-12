package lotto.domain;

import lotto.domain.strategy.RandomLottoNumberStrategy;
import org.junit.jupiter.api.Test;

import java.util.Collections;
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

        LottoMachine actual = new LottoMachine(randomLottoNumberStrategy, new BuyingAmount(1000), Collections.emptyList());
        LottoMachine expected = new LottoMachine(List.of(new Lotto(List.of(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)))), Collections.emptyList());

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 입력된_금액과_입력된_수동_로또를_제외하고_로또_기계가_생성된다() {
        RandomLottoNumberStrategy randomLottoNumberStrategy = new RandomLottoNumberStrategy() {
            @Override
            protected List<Integer> createRandomNumbers() {
                return List.of(1, 2, 3, 4, 5, 6);
            }
        };

        LottoMachine actual = new LottoMachine(randomLottoNumberStrategy, new BuyingAmount(2000),
                List.of(new Lotto(List.of(new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)))));
        LottoMachine expected = new LottoMachine(List.of(new Lotto(List.of(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)))), Collections.emptyList());

        assertThat(actual).isEqualTo(expected);
    }

}
