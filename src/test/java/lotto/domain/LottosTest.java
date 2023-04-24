package lotto.domain;

import lotto.domain.strategy.LottoStrategy;
import lotto.domain.strategy.TestStrategy;
import lotto.domain.winning.WinningStat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    final LottoStrategy testStrategy = new TestStrategy();

    @Test
    @DisplayName("객체 생성 테스트")
    void create() {
        final int unitCount = 6;

        assertThat(new Lottos(unitCount, testStrategy))
                .extracting("lottos")
                .asList()
                .hasSize(unitCount);
    }

    @Test
    @DisplayName("당첨 통계 구하기")
    void rating() {
        final int unitCount = 6;
        final Lotto winningLotto = Lotto.winningLotto("1,2,3,4,5,6");

        assertThat(new Lottos(unitCount, testStrategy).rating(winningLotto))
                .isInstanceOf(WinningStat.class);
    }
}
