package lotto.auto.strategy;

import lotto.auto.model.LottoGame;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AutoLottoGameRuleTest {
    @Test
    @DisplayName("자동 로또 인스턴스가 제대로 생성되는지 테스트 한다")
    void init() {
        AutoLotto autoLotto = AutoLotto.init();
        Assertions.assertThat(autoLotto).isInstanceOf(LottoRule.class);
        Assertions.assertThat(autoLotto).isInstanceOf(AutoLotto.class);
    }

    @Test
    @DisplayName("자동 로또 한게임을 테스트 한다")
    void ticketing() {
        AutoLotto autoLotto = AutoLotto.init();
        LottoGame lottoGame = autoLotto.ticketing();
        Assertions.assertThat(lottoGame.size()).isNotNull().isEqualTo(6);
    }
}
