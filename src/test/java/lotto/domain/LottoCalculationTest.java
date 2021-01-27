package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LottoCalculationTest {
    static LottoCalculation lottoCalculation;

    @BeforeAll
    static void initAll() {
        lottoCalculation = new LottoCalculation();
    }

    @Test
    void isBonusBallTest () {
        Assertions.assertThat(lottoCalculation.isBonusBall(1, 1)).isTrue();
        Assertions.assertThat(lottoCalculation.isBonusBall(1, 2)).isFalse();
    }

}
