package lotto.domain;

import lotto.domain.type.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.fixture.Fixture.getLottoNumbersFixture;
import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {
    @DisplayName("로또 끼리 비교해 몇개가 일치하는지 알 수 있다.")
    @Test
    void matchCount() {
        Lottos lottos = Lottos.create(List.of(new ManualLotto(getLottoNumbersFixture(1, 2, 3, 4, 5, 6))));
        WinningLotto winningLotto = new WinningLotto(new ManualLotto(getLottoNumbersFixture(1, 20, 3, 40, 5, 6)),
                LottoNumber.of(45));

        List<Rank> ranks = winningLotto.match(lottos);

        assertThat(ranks).contains(Rank.FOURTH)
                .hasSize(1);
    }

    @DisplayName("보너스 번호인지 확인이 가능하다.")
    @Test
    void checkBonus() {
        Lottos lottos = Lottos.create(List.of(new ManualLotto(getLottoNumbersFixture(1, 2, 3, 4, 5, 6))));
        WinningLotto winningLotto = new WinningLotto(new ManualLotto(getLottoNumbersFixture(1, 2, 3, 4, 5, 45)),
                LottoNumber.of(6));

        List<Rank> ranks = winningLotto.match(lottos);

        assertThat(ranks).contains(Rank.BONUS)
                .hasSize(1);
    }
}