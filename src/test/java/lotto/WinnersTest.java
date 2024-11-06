package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinnersTest {

    @Test
    @DisplayName("당첨 번호도 로또 번호와 동일한 제약 설정")
    void testWinnersConstraint() {
        assertThatThrownBy(() -> {
            new Winners(new LottoNumbers("100"), new LottoNumber(1));
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new Winners(new LottoNumbers("0, 16, 21, 25, 38, 40"), new LottoNumber(1));
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new Winners(new LottoNumbers("46, 16, 21, 25, 38, 40"), new LottoNumber(1));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 통계를 계산한다.")
    void testPrintWinners() {
        List<LottoNumbers> lottos = List.of(
                new LottoNumbers(new LottoRandomGenerator(1L)),
                new LottoNumbers(new LottoRandomGenerator(2L))
        );
        Orders orders = new Orders(lottos);

        Winners winners = new Winners(new LottoNumbers("14, 16, 21, 25, 38, 40"), new LottoNumber(1));
        Statistics statistics = winners.match(orders);

        assertThat(statistics.get(WinningRule.THREE)).isEqualTo(0);
        assertThat(statistics.get(WinningRule.FOUR)).isEqualTo(0);
        assertThat(statistics.get(WinningRule.FIVE)).isEqualTo(1);
        assertThat(statistics.get(WinningRule.SIX)).isEqualTo(0);
    }

    @Test
    @DisplayName("보너스 번호를 포함한 당첨 통계를 계산한다.")
    void testPrintWinnersWithBonus() {
        List<LottoNumbers> lottos = List.of(
                new LottoNumbers(new LottoRandomGenerator(1L)),
                new LottoNumbers(new LottoRandomGenerator(2L))
        );
        Orders orders = new Orders(lottos);

        Winners winners = new Winners(new LottoNumbers("14, 16, 21, 25, 38, 40"), new LottoNumber(43));
        Statistics statistics = winners.match(orders);

        assertThat(statistics.get(WinningRule.THREE)).isEqualTo(0);
        assertThat(statistics.get(WinningRule.FOUR)).isEqualTo(0);
        assertThat(statistics.get(WinningRule.FIVE)).isEqualTo(0);
        assertThat(statistics.get(WinningRule.FIVE_BONUS)).isEqualTo(1);
        assertThat(statistics.get(WinningRule.SIX)).isEqualTo(0);
    }
}
