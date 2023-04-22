package lotto.domain;

import lotto.domain.strategy.LottoStrategy;
import lotto.domain.strategy.TestStrategy;
import lotto.dto.WinningStatDto;
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
                .extracting("lottoList")
                .asList()
                .hasSize(unitCount);
    }

    @Test
    @DisplayName("당첨 통계 구하기")
    void rating() {
        final int unitCount = 6;
        final Lotto winningLotto = new Lotto(testStrategy);

        assertThat(new Lottos(unitCount, testStrategy).rating(winningLotto))
                .isInstanceOf(WinningStatDto.class)
                .extracting("firstCount")
                .isEqualTo(unitCount);
    }
}
