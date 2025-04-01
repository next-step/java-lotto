package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest {
    @Test
    void createTest() {
        assertThat(new LottoGame(Collections.emptyList(), null)).isNotNull();
    }

    @DisplayName("로또 당첨 개수를 구할 수 있다.")
    @Test
    void getRanksTest() {
        // given
        List<Lotto> userBuyLotto = Collections.singletonList(new FakeStrategy(List.of(1, 2, 3, 4, 5, 6)).generate());
        Lotto winLotto = new FakeStrategy(List.of(6, 5, 4, 3, 2, 16)).generate();
        LottoNo bonusNumber = new LottoNo(14);

        // when
        LottoGame lottoGame = new LottoGame(userBuyLotto, new WinningLotto(winLotto, bonusNumber));

        // then
        assertThat(lottoGame.getRanks()).hasSize(1);
        assertThat(lottoGame.getRanks().get(Rank.THIRD)).isEqualTo(1);
    }
}
