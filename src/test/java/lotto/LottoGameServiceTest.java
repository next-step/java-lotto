package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameServiceTest {


    @ParameterizedTest
    @CsvSource(value = {"14000:14", "0:0", "1000:1"}, delimiter = ':')
    public void buyLottoTest(int buyAmt, int buyQty) {
        assertThat(LottoGameService.buyLotto(buyAmt).getLottoList().size()).isEqualTo(buyQty);
    }

    @Test
    public void getMatchLottoCntTest() {
        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(1);
        lottoNumbers.add(2);
        lottoNumbers.add(3);
        lottoNumbers.add(5);
        lottoNumbers.add(6);
        lottoNumbers.add(7);
        Lotto lotto = new Lotto(lottoNumbers);
        int[] winnerLottoNumbers = {1,2,3,4,5,6};
        LottoWinner lottoWinner = new LottoWinner(winnerLottoNumbers);
        assertThat(lottoWinner.getMatchLottoCnt(lotto)).isEqualTo(5);
    }

    @Test
    public void getLottoMatchStatisticsTest() {
        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(1);
        lottoNumbers.add(2);
        lottoNumbers.add(3);
        lottoNumbers.add(5);
        lottoNumbers.add(6);
        lottoNumbers.add(7);
        Lotto lotto = new Lotto(lottoNumbers);
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto);
        LottoTicket lottoTicket = new LottoTicket(lottoList);
        int[] winnerLottoNumbers = {1,2,3,4,5,6};
        LottoWinner lottoWinner = new LottoWinner(winnerLottoNumbers);
        List<Rank> lottoRank = lottoWinner.matchingWinnerNumber(lottoTicket);
        assertThat(LottoGameService.getLottoMatchStatistics(lottoRank, 5)).isEqualTo(1);
    }
}
