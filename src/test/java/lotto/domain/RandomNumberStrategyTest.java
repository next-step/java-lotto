package lotto.domain;

import lotto.domain.LottoNumberStrategy;
import lotto.domain.RandomNumberStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomNumberStrategyTest {

    @Test
    void 로또에_제공하는_번호가_범위내_중복되지_않는지_테스트() {
        LottoNumberStrategy randomNumberStrategy = new RandomNumberStrategy();
        Assertions.assertThat(randomNumberStrategy.provideNumberSet())
            .filteredOn(number -> number.getNumber() <= 45)
            .hasSize(6)
            .doesNotHaveDuplicates();
    }
}