package lotto.domain;

import lotto.generator.Lotto45NumbersMakeStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest {
    @Test
    @DisplayName("시도한 수만큼 로또를 얻는다.")
    void tryNumber_getLotto() {
        LottoGame lottoGame = LottoGame.create(new Money(6_000), new Lotto45NumbersMakeStrategy());
        Assertions.assertThat(lottoGame.getLotto().size()).isEqualTo(6);
    }

}
