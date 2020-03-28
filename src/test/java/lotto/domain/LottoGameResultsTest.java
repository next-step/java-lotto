package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameResultsTest {

    @DisplayName("구매한 로또 티켓들 중 당첨된 티켓의 수를 계산하는 테스트")
    @Test
    public void lottoGameResultTest() {
        LottoNumber lottoNumber1 = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber lottoNumber2 = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber winningNumber = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTickets lottoTickets = new LottoTickets(lottoNumber1, lottoNumber2);
        LottoGameResults lottoGameResults = LottoGameMatcher.matchWinningNumber(lottoTickets, winningNumber);

        assertThat(lottoGameResults.getWinningGames()).hasSize(2);
    }

    @DisplayName("로또 수익률 계산 테스트")
    @Test
    public void lottoProfitRateTest() {
        LottoNumber lottoNumber = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber winningNumber = new LottoNumber(Arrays.asList(1, 2, 3, 10, 11, 12));
        LottoTickets lottoTickets = new LottoTickets(lottoNumber);
        LottoGameResults lottoGameResults = LottoGameMatcher.matchWinningNumber(lottoTickets, winningNumber);

        assertThat(lottoGameResults.getProfitRate()).isEqualTo(5);
    }

    @DisplayName("3개가 일치하면 상금은 5000원 이다.")
    @Test
    public void matchedThreePrizeTest() {
        LottoNumber lottoNumber = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber winningNumber = new LottoNumber(Arrays.asList(1, 2, 3, 10, 11, 12));
        LottoTickets lottoTickets = new LottoTickets(lottoNumber);
        LottoGameResults lottoGameResults = LottoGameMatcher.matchWinningNumber(lottoTickets, winningNumber);

        LottoRank lottoRank = lottoGameResults.getWinningGames().get(0);

        assertThat(lottoRank.getMatchCount()).isEqualTo(3);
        assertThat(lottoRank.getWinningPrize()).isEqualTo(5000);
    }

}
