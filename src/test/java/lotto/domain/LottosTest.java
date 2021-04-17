package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    @DisplayName("돈을 입력받은만큼 로또로 교환하기")
    void create() {
        Money money = Money.of(14000);
        Lottos lottos = Lottos.of(money);

        assertThat(lottos.size()).isEqualTo(14);
    }

    @Test
    @DisplayName("로또 번호 당첨 개수 확인")
    void check() {
        Money money = Money.of(14000);
        Lottos lottos = Lottos.of(money);
        List<Integer> winningCounts = lottos.match(WinningLotto.of(1, 2, 3, 4, 5, 6));

        assertThat(winningCounts).isNotNull();
    }
}
