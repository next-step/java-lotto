package lotto.backend.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    LottoTicket winningLotto;
    LottoTickets purchasedLotto;
    LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        this.winningLotto = LottoTicket.of(new int[]{1, 7, 10, 23, 40, 42});
        this.purchasedLotto = new LottoTickets(List.of(
                LottoTicket.of(new int[]{1, 7, 10, 23, 40, 42}), //6개 모두 일치(1등)
                LottoTicket.of(new int[]{2, 4, 10, 23, 40, 42})  //4개 일치(3등)
        ));
        this.lottoResult = LottoResult.of(winningLotto, purchasedLotto);
    }

    @Test
    @DisplayName("1등 과 3등 총 당첨금액 계산")
    void prize_amount() {
        int expected = 2_000_000_000 + 50_000;
        assertThat(lottoResult.getPrize()).isEqualTo(expected);
    }

    @Test
    @DisplayName("2000원으로 1등 과 3등이 당첨됐을 경우 수익률")
    void profit() {
        double expected = (double) (2_000_000_000 + 50_000) / 2_000;
        assertThat(lottoResult.getProfit()).isEqualTo(expected);
    }
}
