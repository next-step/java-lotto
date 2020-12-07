package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameServiceTest {


    @ParameterizedTest
    @CsvSource(value = {"14000:14", "0:0", "1000:1"}, delimiter = ':')
    public void buyLottoTest(int buyAmt, int buyQty) {
        assertThat(LottoGameService.buyLotto(buyAmt).getLottoList().size()).isEqualTo(buyQty);
    }

    @Test
    public void getMatchLottoCntTest() {
        List<LottoNumber> lottoNumbers = Arrays.asList(1, 2, 3, 5, 6, 7).stream().map(LottoNumber::new).collect(Collectors.toList());
        Lotto lotto = new Lotto(lottoNumbers);
        int[] winnerLottoNumbersArr = {1,2,3,4,5,6};
        LottoNumber[] winnerLottoNumbers = Arrays.stream(winnerLottoNumbersArr).boxed().map(LottoNumber::new).toArray(LottoNumber[]::new);
        int bonusLottoNumber = 7;
        Lotto lottoWinner = new Lotto(winnerLottoNumbers, new LottoNumber(bonusLottoNumber));
        assertThat(lottoWinner.getMatchLottoCnt(lotto)).isEqualTo(5);
    }

    @Test
    public void getLottoMatchStatisticsTest() {
        List<LottoNumber> lottoNumbers = Arrays.asList(1, 2, 3, 5, 6, 7).stream().map(LottoNumber::new).collect(Collectors.toList());
        Lotto lotto = new Lotto(lottoNumbers);
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto);
        LottoTicket lottoTicket = new LottoTicket(lottoList);
        int[] winnerLottoNumbersArr = {1,2,3,4,5,6};
        LottoNumber[] winnerLottoNumbers = Arrays.stream(winnerLottoNumbersArr).boxed().map(LottoNumber::new).toArray(LottoNumber[]::new);
        int bonusLottoNumber = 7;
        Lotto lottoWinner = new Lotto(winnerLottoNumbers, new LottoNumber(bonusLottoNumber));
        List<Rank> lottoRank = lottoWinner.matchingWinnerNumber(lottoTicket);
        Rank rank = Rank.SECOND;
        assertThat(LottoGameService.getLottoMatchStatistics(lottoRank, rank)).isEqualTo(1);
    }
}
