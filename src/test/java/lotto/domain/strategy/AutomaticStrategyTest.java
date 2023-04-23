package lotto.domain.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AutomaticStrategyTest {

    @Test
    @DisplayName("객체 생성 테스트")
    void create() {
        assertThat(new AutomaticStrategy())
                .isInstanceOf(LottoStrategy.class)
                .isNotNull();
    }

    @Test
    @DisplayName("자동 구매 로또 넘버 생성 테스트")
    void lottoNumbers() {
        final LottoStrategy lottoStrategy = new AutomaticStrategy();

        assertThat(lottoStrategy.lottoNumbers())
                .hasSize(6);
    }
}
