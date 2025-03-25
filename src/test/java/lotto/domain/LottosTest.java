package lotto.domain;

import lotto.enums.Rank;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    @Test
    void 결과_출력_테스트() {
        // given
        Lottos lottos = new Lottos(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8))
        ));
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        int bonusNumber = 7;

        // when
        Rewards result = lottos.getResult(winningNumbers, bonusNumber);

        // then
        assertThat(result.getMatchCounts()).isEqualTo(Map.of(Rank.FIRST, 1, Rank.SECOND, 1, Rank.THIRD, 1));
    }
}