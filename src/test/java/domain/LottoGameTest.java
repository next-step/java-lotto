package domain;

import step2.domain.LottoGame;
import step2.generator.Lotto45NumbersStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest {

    @Test
    @DisplayName("시도한 수만큼 로또를 얻는다.")
    void tryNumber_getLotto() {
        LottoGame lottoGame = LottoGame.create(6, new Lotto45NumbersStrategy());
        Assertions.assertThat(lottoGame.getLottos().size()).isEqualTo(6);
    }

}