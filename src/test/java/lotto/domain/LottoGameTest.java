package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @Test
    @DisplayName("입력된 금액만큼의 로또가 생성되어야 한다")
    void generate_lotto() {
        assertThat(new LottoGame(14000).lottos()).hasSize(14);
    }

    @Test
    @DisplayName("2개 생성 - 1등, 4등")
    void winningResult() {
        Lottos lottos = new Lottos(List.of(new Lotto(1, 2, 3, 4, 5, 6), new Lotto(1, 2, 3, 9, 10, 11)));
        Money money = new Money(2000);
        assertThat(new LottoGame(lottos, money).check(new Lotto(1, 2, 3, 4, 5, 6)).getCount(Rank.FIRST)).isEqualTo(1);
        assertThat(new LottoGame(lottos, money).check(new Lotto(1, 2, 3, 4, 5, 6)).getCount(Rank.FIFTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("2_000원으로 10_000원을 벌면 수익률은 5이다")
    void rateOfReturn() {
        Lottos lottos = new Lottos(List.of(new Lotto(1, 2, 3, 4, 5, 6), new Lotto(1, 2, 4, 9, 10, 11)));
        Money money = new Money(2000);
        LottoGame lottoGame = new LottoGame(lottos, money);
        LottoResult result = lottoGame.check(new Lotto(1, 2, 3, 20, 23, 45));
        assertThat(lottoGame.rateOfReturn(result)).isEqualTo(2.5);
    }
}