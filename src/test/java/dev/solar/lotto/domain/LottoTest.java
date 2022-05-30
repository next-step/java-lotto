package dev.solar.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoTest {

    @DisplayName("로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급한다.")
    @CsvSource(value = { "14000:14", "13500:13", "0:0" }, delimiter = ':')
    @ParameterizedTest
    void issue_lotto_equal_purchase_amount(int payment, int purchaseAmount) {
        assertThat(Lotto.buyLottoTickets(payment).getRemainingLottoTicket()).isEqualTo(purchaseAmount);
    }

    @DisplayName("로또 한 장당 6개의 번호를 랜덤으로 선택한다.")
    @Test
    void pick_lotto_random_number() {
        final Lotto lotto = Lotto.buyLottoTickets(1000);
        LottoTicket lottoTicket = lotto.pick();
        System.out.println(lottoTicket);
        assertThat(lottoTicket.getLottoNumbers()).hasSize(6);
    }

    @DisplayName("수동으로 로또를 구매한다.")
    @Test
    void pick_manual_lotto_number() {
        final Lotto lotto = Lotto.buyLottoTickets(1000);
        lotto.pick(new LottoTicket(Set.of(1, 2, 3, 4, 5, 6)));
        assertThat(lotto.isEmptyNewLottoTickets()).isTrue();
        final WinningLotto winningLotto = new WinningLotto(Set.of(1, 2, 3, 4, 5, 6), 7);
        final ResultBoard resultBoard = lotto.checkWinningResult(winningLotto);
        final Rank match = winningLotto.match(lotto.getLottoTickets().get(0));
        assertThat(match).isEqualTo(Rank.FIRST);
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void calculate_profit_margin() {
        final int payment = 14000;
        final Lotto lotto = new Lotto(payment);
        final ResultBoard resultBoard = new ResultBoard();
        resultBoard.addResult(Rank.THIRD);

        final double actual = lotto.calculateProfitMargin(resultBoard);
        assertThat(actual).isEqualTo(Rank.THIRD.getPrizeMoney() / (double) payment, withPrecision(0.01));
    }
}
