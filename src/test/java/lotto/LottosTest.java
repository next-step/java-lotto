package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    @DisplayName("로또 결과")
    void test1() {
        // given
        Lottos lottos = new Lottos(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = WinningLotto.builder()
                .winningNumbers(1, 2, 3, 4, 5, 6)
                .bonusBall(7)
                .build();
        // when
        Map<Winning, Integer> results = lottos.matching(winningLotto);
        // then
        assertThat(results).containsEntry(Winning.SIXTH, 1);
    }
}
