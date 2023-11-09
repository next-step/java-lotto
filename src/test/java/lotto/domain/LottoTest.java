package lotto.domain;

import lotto.strategy.FixtureNumberStrategy;
import lotto.strategy.NumberStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName("로또 번호 발급")
    @Test
    void 로또_번호_발급() {
        // given
        NumberStrategy numberStrategy = new FixtureNumberStrategy();
        // when
        Lotto lotto = new Lotto(numberStrategy.create(1).get(0).lottoNumbers());
        // then
        assertThat(lotto.lottoNumbers()).hasSize(6);
    }
}
