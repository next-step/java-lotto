package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottosTest {
    @Test
    @DisplayName("Lottos는 생성된 숫자만큼의 로또를 가진다")
    void size() {
        assertThat(new Lottos(3).values()).hasSize(3);
    }

    @Test
    @DisplayName("1등 당첨")
    void findResult() {
        Lottos userLottos = new Lottos(List.of(new Lotto(1, 2, 3, 4, 5, 6)));
        WinningLotto winningLotto = new WinningLotto(new Lotto(1, 2, 3, 4, 5, 6), 7);

        LottoResult result = userLottos.findResult(winningLotto);

        assertThat(result.getCount(Rank.FIRST)).isEqualTo(1);
    }
}