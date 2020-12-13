package lotto;

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
        assertThat(LottoGameService.autoBuyLotto(buyAmt, LottoTicket.from(new ArrayList<>())).getLottoTicketSize()).isEqualTo(buyQty);
    }

    @ParameterizedTest
    @CsvSource(value = {"14000:2:12", "0:0:0", "1000:0:1"}, delimiter = ':')
    public void manualBuyLottoTest(int buyAmt, int manualBuyLottoQty, int buyQty) {
        List<Lotto> lottoList = new ArrayList<>();
        for(int i=0; i<manualBuyLottoQty; i++){
            lottoList.add(Lotto.from());
        }
        LottoTicket lottoTicket = LottoTicket.from(lottoList);
        assertThat(LottoGameService.autoBuyLotto(buyAmt, lottoTicket).getLottoTicketSize()).isEqualTo(buyQty);
    }


    @Test
    public void getMatchLottoCntTest() {
        List<LottoNumber> lottoNumbers = Arrays.asList(1, 2, 3, 5, 6, 7).stream().map(LottoNumber::from).collect(Collectors.toList());
        Lotto lotto = Lotto.from(lottoNumbers);
        int[] winnerLottoNumbersArr = {1,2,3,4,5,6};
        LottoNumber[] winnerLottoNumbers = Arrays.stream(winnerLottoNumbersArr).boxed().map(LottoNumber::from).toArray(LottoNumber[]::new);
        int bonusLottoNumber = 7;
        LottoWinner lottoWinner = LottoWinner.of(winnerLottoNumbers, LottoNumber.from(bonusLottoNumber));
        assertThat(lottoWinner.getMatchLottoCnt(lotto)).isEqualTo(5);
    }

    @Test
    public void getLottoMatchStatisticsTest() {
        List<LottoNumber> lottoNumbers = Arrays.asList(1, 2, 3, 5, 6, 7).stream().map(LottoNumber::from).collect(Collectors.toList());
        Lotto lotto = Lotto.from(lottoNumbers);
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto);
        LottoTicket lottoTicket = LottoTicket.from(lottoList);
        int[] winnerLottoNumbersArr = {1,2,3,4,5,6};
        LottoNumber[] winnerLottoNumbers = Arrays.stream(winnerLottoNumbersArr).boxed().map(LottoNumber::from).toArray(LottoNumber[]::new);
        int bonusLottoNumber = 7;
        LottoWinner lottoWinner = LottoWinner.of(winnerLottoNumbers, LottoNumber.from(bonusLottoNumber));
        List<Rank> lottoRank = lottoWinner.matchingWinnerNumber(lottoTicket);
        Rank rank = Rank.SECOND;
        assertThat(LottoGameService.getLottoMatchStatistics(lottoRank, rank)).isEqualTo(1);
    }
}
