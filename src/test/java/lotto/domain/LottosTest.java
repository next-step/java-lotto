package lotto.domain;

import lotto.factory.LottoFactory;
import lotto.generator.TestLottoNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    private List<Lotto> manualLottos;

    @BeforeEach
    void setUp() {
        this.manualLottos = Collections.emptyList();
    }

    @DisplayName("구매금액에 따른 로또 구매개수 확인")
    @ParameterizedTest
    @CsvSource(value = {"1000,1", "5000,5"})
    void of(int amount, int expectedPurchaseCount) {
        // given
        List<Lotto> autoLottos = LottoFactory.buyAutoLottos(new TestLottoNumberGenerator(), Money.from(amount));

        // when
        Lottos lottos = Lottos.of(manualLottos, autoLottos);

        // then
        assertThat(lottos.getLottoCount()).isEqualTo(expectedPurchaseCount);
    }

    @DisplayName("1등 번호를 금액만큼 구입하면 구입장수만큼 count를 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1000,1", "5000,5"})
    void getRankCount(int amount, int expectedRankCount) {
        // given
        List<Lotto> autoLottos = LottoFactory.buyAutoLottos(new TestLottoNumberGenerator(), Money.from(amount));
        Lottos lottos = Lottos.of(manualLottos, autoLottos);

        // when
        WinningLotto winningLotto = WinningLotto.of(Lotto.from(new TestLottoNumberGenerator()), Number.from(7));
        Rank rank = Rank.valueOf(6, false);
        int rankCount = lottos.getRankCount(winningLotto, rank);

        // then
        assertThat(rankCount).isEqualTo(expectedRankCount);
    }
}
