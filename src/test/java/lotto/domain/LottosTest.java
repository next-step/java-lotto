package lotto.domain;

import lotto.generator.TestLottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @DisplayName("구매금액에 따른 로또 구매개수 확인")
    @ParameterizedTest
    @CsvSource(value = {"1000,1", "5000,5"})
    void of(int amount, int expectedPurchaseCount) {
        // given
        Money money = Money.from(amount);

        // when
        Lottos lottos = Lottos.of(new TestLottoNumberGenerator(), money);

        // then
        assertThat(lottos.getLottoCount()).isEqualTo(expectedPurchaseCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000,1", "10000,10"})
    void getRankCount(int amount, int expectedRankCount) {
        // given
        Lottos lottos = Lottos.of(new TestLottoNumberGenerator(), Money.from(amount));
        WinningLotto winningLotto = WinningLotto.of(Lotto.from(new TestLottoNumberGenerator()), Number.from(7));
        Rank rank = Rank.valueOf(6, false);

        // when
        int rankCount = lottos.getRankCount(winningLotto, rank);

        // then
        assertThat(rankCount).isEqualTo(expectedRankCount);
    }
}
