package lotto.domain;


import lotto.domain.strategy.LottoStrategy;
import lotto.domain.strategy.TestStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {
    final LottoStrategy testStrategy = new TestStrategy();

    @Test
    @DisplayName("객체 생성 테스트")
    void create() {
        final LottoNumbers lottoNumbers = new LottoNumbers(testStrategy);

        assertThat(lottoNumbers)
                .extracting("lottoNumbers")
                .isNotNull()
                .asList()
                .hasSize(6);
    }
}
