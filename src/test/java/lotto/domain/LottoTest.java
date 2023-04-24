package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("Lotto 발급")
    void publishLottoTest() {
        Lotto lotto = Lotto.initLotto();
        assertThat(lotto.getLottoSize())
                .isEqualTo(6);
    }

    @Test
    @DisplayName("Lotto 수동 입력 테스트")
    void manualLottoTest() {
        List<String> stringLottos = List.of("1", "2", "3", "4", "5", "6");
        Lotto lotto = Lotto.initWinningLotto(stringLottos);

        assertThat(lotto.getLottoSize())
                .isEqualTo(6);
    }

    @Test
    @DisplayName("통계 테스트")
    void findStatisticsTest() {
        Lotto winningLotto = Lotto.initWinningLotto(List.of("1", "2", "3", "4", "5", "6"));

        Lotto lotto = Lotto.initWinningLotto(List.of("1", "2", "3", "4", "5", "6"));

        assertThat(lotto.findMatchingBall(winningLotto)).isEqualTo(6);
    }

}