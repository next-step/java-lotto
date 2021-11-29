package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static lotto.fixture.LottoTicketFixture.LOTTO_TICKETS;
import static lotto.fixture.LottoTicketFixture.PROFIT_RATE;
import static lotto.fixture.WinningNumbersFixture.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @DisplayName("로또당첨결과를 반환한다.")
    @Test
    void createResult() {
        // given
        WinningNumbers winningNumbers = WINNING_NUMBERS;

        // when
        LottoResult lottoResult = LottoResult.createResult(LOTTO_TICKETS, winningNumbers);
        Map<Rank, Integer> result = lottoResult.getResult();

        // then
        Assertions.assertAll(
                () -> assertThat(result.get(Rank.FIRST)).isEqualTo(1),
                () -> assertThat(result.get(Rank.FOURTH)).isEqualTo(1)
        );
    }

    @DisplayName("로또 수익률을 계산한다.")
    @Test
    void calculateProfitRate() {
        // given
        WinningNumbers winningNumbers = WINNING_NUMBERS;

        // when
        LottoResult lottoResult = LottoResult.createResult(LOTTO_TICKETS, winningNumbers);

        // then
        assertThat(lottoResult.getProfitRate()).isEqualTo(PROFIT_RATE);
    }

}
