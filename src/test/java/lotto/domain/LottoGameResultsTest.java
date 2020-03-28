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
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        LottoTickets lottoTickets = new LottoTickets(lottoNumber1, lottoNumber2);
        LottoGameResults lottoGameResults = LottoGameMatcher.matchWinningNumber(lottoTickets, winningNumber);

        assertThat(lottoGameResults.getWinningGames()).hasSize(2);
    }

    @DisplayName("1게임 샀을 때 5등 당첨 1개 로또 수익률 계산 테스트")
    @Test
    public void lottoProfitRateTest() {
        LottoNumber lottoNumber = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 10, 11, 12), 13);
        LottoTickets lottoTickets = new LottoTickets(lottoNumber);
        LottoGameResults lottoGameResults = LottoGameMatcher.matchWinningNumber(lottoTickets, winningNumber);

        assertThat(lottoGameResults.getProfitRate()).isEqualTo(5);
    }

    @DisplayName("1게임 샀을 때 2등 당첨 1개 로또 수익률 계산 테스트")
    @Test
    public void lottoProfitRateAtFiveBonusTest() {
        LottoNumber lottoNumber = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 12), 6);
        LottoTickets lottoTickets = new LottoTickets(lottoNumber);
        LottoGameResults lottoGameResults = LottoGameMatcher.matchWinningNumber(lottoTickets, winningNumber);

        assertThat(lottoGameResults.getProfitRate()).isEqualTo(300000);
    }

    @DisplayName("1개가 일치하면 상금은 0원 이다.")
    @Test
    public void matchedOnePrizeTest() {
        LottoNumber lottoNumber = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 7, 8, 10, 11, 12), 13);
        LottoTickets lottoTickets = new LottoTickets(lottoNumber);
        LottoGameResults lottoGameResults = LottoGameMatcher.matchWinningNumber(lottoTickets, winningNumber);

        LottoRank lottoRank = lottoGameResults.getWinningGames().get(0);

        assertThat(lottoRank.getMatchCount()).isEqualTo(1);
        assertThat(lottoRank.getWinningPrize()).isEqualTo(LottoRank.ONE.getWinningPrize());
    }

    @DisplayName("2개가 일치하면 상금은 0원 이다.")
    @Test
    public void matchedTwoPrizeTest() {
        LottoNumber lottoNumber = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 7, 10, 11, 12), 13);
        LottoTickets lottoTickets = new LottoTickets(lottoNumber);
        LottoGameResults lottoGameResults = LottoGameMatcher.matchWinningNumber(lottoTickets, winningNumber);

        LottoRank lottoRank = lottoGameResults.getWinningGames().get(0);

        assertThat(lottoRank.getMatchCount()).isEqualTo(2);
        assertThat(lottoRank.getWinningPrize()).isEqualTo(LottoRank.TWO.getWinningPrize());
    }

    @DisplayName("3개가 일치하면 상금은 5000원 이다.")
    @Test
    public void matchedThreePrizeTest() {
        LottoNumber lottoNumber = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 10, 11, 12), 13);
        LottoTickets lottoTickets = new LottoTickets(lottoNumber);
        LottoGameResults lottoGameResults = LottoGameMatcher.matchWinningNumber(lottoTickets, winningNumber);

        LottoRank lottoRank = lottoGameResults.getWinningGames().get(0);

        assertThat(lottoRank.getMatchCount()).isEqualTo(3);
        assertThat(lottoRank.getWinningPrize()).isEqualTo(LottoRank.THREE.getWinningPrize());
    }

    @DisplayName("4개가 일치하면 상금은 50000원 이다.")
    @Test
    public void matchedFourPrizeTest() {
        LottoNumber lottoNumber = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 11, 12), 13);
        LottoTickets lottoTickets = new LottoTickets(lottoNumber);
        LottoGameResults lottoGameResults = LottoGameMatcher.matchWinningNumber(lottoTickets, winningNumber);

        LottoRank lottoRank = lottoGameResults.getWinningGames().get(0);

        assertThat(lottoRank.getMatchCount()).isEqualTo(4);
        assertThat(lottoRank.getWinningPrize()).isEqualTo(LottoRank.FOUR.getWinningPrize());
    }

    @DisplayName("5개가 일치하면 상금은 1_500_000원 이다.")
    @Test
    public void matchedFivePrizeTest() {
        LottoNumber lottoNumber = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 12), 13);
        LottoTickets lottoTickets = new LottoTickets(lottoNumber);
        LottoGameResults lottoGameResults = LottoGameMatcher.matchWinningNumber(lottoTickets, winningNumber);

        LottoRank lottoRank = lottoGameResults.getWinningGames().get(0);

        assertThat(lottoRank.getMatchCount()).isEqualTo(5);
        assertThat(lottoRank.getWinningPrize()).isEqualTo(LottoRank.FIVE.getWinningPrize());
    }

    @DisplayName("5개가 일치하고 보너스번호도 일치하면 상금은 300_000_000원 이다.")
    @Test
    public void matchedFiveBonusPrizeTest() {
        LottoNumber lottoNumber = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 12), 6);
        LottoTickets lottoTickets = new LottoTickets(lottoNumber);
        LottoGameResults lottoGameResults = LottoGameMatcher.matchWinningNumber(lottoTickets, winningNumber);

        LottoRank lottoRank = lottoGameResults.getWinningGames().get(0);

        assertThat(lottoRank.getMatchCount()).isEqualTo(51);
        assertThat(lottoRank.getWinningPrize()).isEqualTo(LottoRank.FIVE_BONUS.getWinningPrize());
    }

    @DisplayName("6개가 일치하면 상금은 2_000_000_000원 이다.")
    @Test
    public void matchedSixPrizeTest() {
        LottoNumber lottoNumber = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 13);
        LottoTickets lottoTickets = new LottoTickets(lottoNumber);
        LottoGameResults lottoGameResults = LottoGameMatcher.matchWinningNumber(lottoTickets, winningNumber);

        LottoRank lottoRank = lottoGameResults.getWinningGames().get(0);

        assertThat(lottoRank.getMatchCount()).isEqualTo(6);
        assertThat(lottoRank.getWinningPrize()).isEqualTo(LottoRank.SIX.getWinningPrize());
    }

}
