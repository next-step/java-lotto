package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {

    @DisplayName("로또 번호로 로또 번호들을 만들 수 있다.")
    @Test
    public void newLottoNumberInstanceTest() {
        LottoNumber game1 = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber game2 = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));

        LottoNumbers lottoNumbers = new LottoNumbers(game1, game2);

        assertThat(lottoNumbers.size()).isEqualTo(2);
    }

    @DisplayName("당첨 번호를 입력하면 각 로또 번호중 일치하는 번호의 개수를 반환한다.")
    @Test
    public void returnMatchedNumberCountTest() {
        LottoNumber game1 = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber game2 = new LottoNumber(Arrays.asList(7, 8, 9, 10, 11, 12));
        LottoNumbers boughtNumbers = new LottoNumbers(game1, game2);

        LottoNumber winningNumber = new LottoNumber(Arrays.asList(5, 6, 7, 8, 9, 10));
        List<Long> lottoGameResult = boughtNumbers.getCheckedNumbers(winningNumber);

        assertThat(lottoGameResult).hasSize(2);
        assertThat(lottoGameResult.get(0)).isEqualTo(2);
        assertThat(lottoGameResult.get(1)).isEqualTo(4);
    }

    @DisplayName("당첨 내역에 따라 당첨 금액이 결정된다")
    @Test
    public void winningPrizeTest() {
        LottoNumber game1 = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber game2 = new LottoNumber(Arrays.asList(7, 8, 9, 10, 11, 12));
        LottoNumber game3 = new LottoNumber(Arrays.asList(7, 8, 9, 10, 11, 12));
        LottoNumbers boughtNumbers = new LottoNumbers(game1, game2, game3);
        LottoNumber winningNumber = new LottoNumber(Arrays.asList(5, 6, 7, 8, 9, 10));

        LottoGameResults lottoGameResults = LottoGameMatcher.matchWinningNumber(boughtNumbers, winningNumber);
        List<Long> results = lottoGameResults.getWinningGames();
        double winningPrizeSum = (long) lottoGameResults.getWinningPrizeSum();

        assertThat(results).hasSize(2);
        assertThat(results.get(0)).isEqualTo(4);
        assertThat(results.get(1)).isEqualTo(4);
        assertThat(winningPrizeSum).isEqualTo(100000);

    }

}
