package lotto.domain;


import lotto.domain.strategy.LottoStrategy;
import lotto.domain.strategy.TestStrategy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    final LottoStrategy lottoStrategy = new TestStrategy();

    @Test
    void create() {
        assertThat(new Lotto(lottoStrategy))
                .extracting("lottoNumbers")
                .isNotNull();
    }
}
