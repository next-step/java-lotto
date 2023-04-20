package lotto.domain;

import lotto.domain.strategy.LottoStrategy;
import lotto.domain.strategy.TestStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoListTest {
    final LottoStrategy lottoStrategy = new TestStrategy();

    @Test
    @DisplayName("객체 생성 테스트")
    void create() {
        final int unitCount = 6;

        assertThat(new LottoList(unitCount, lottoStrategy))
                .extracting("lottoList")
                .asList()
                .hasSize(unitCount);
    }
}
