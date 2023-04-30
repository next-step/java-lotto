package lotto_auto;

import lotto_auto.domain.Lotto;
import lotto_auto.domain.LottoNumber;
import lotto_auto.domain.LottoTickets;
import lotto_auto.domain.LottoWinner;
import lotto_auto.service.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoResultTest {


    @DisplayName("로또 당첨결과 통계 확인")
    @ParameterizedTest
    @CsvSource(value = {"6:1", "5:1", "4:0", "3:0"}, delimiter = ':')
    public void countOfMatch(Integer input, Integer expected) {
        List<LottoNumber> lottoNumbers1 = Arrays.asList(new LottoNumber(1), new LottoNumber(12), new LottoNumber(33), new LottoNumber(44), new LottoNumber(15), new LottoNumber(36));
        List<LottoNumber> lottoNumbers2 = Arrays.asList(new LottoNumber(1), new LottoNumber(12), new LottoNumber(33), new LottoNumber(44), new LottoNumber(15), new LottoNumber(7));
        List<Lotto> lottoList = Arrays.asList(new Lotto(lottoNumbers1), new Lotto(lottoNumbers2));
        LottoTickets tickets = new LottoTickets(lottoList);
        String winnerLottoInput = "1,12,33,44,15,36";

        LottoWinner lottoWinner = new LottoWinner(winnerLottoInput);
        LottoResult lottoResult = new LottoResult();
        lottoResult.calculateResult(tickets, lottoWinner);

        assertThat(lottoResult.getCountOfMatch(input)).isEqualTo(expected);
    }

    @DisplayName("로또 당첨결과 수익률 확인")
    @Test
    public void getRevenueRate() {
        List<LottoNumber> lottoNumbers1 = Arrays.asList(new LottoNumber(1), new LottoNumber(12), new LottoNumber(33), new LottoNumber(44), new LottoNumber(15), new LottoNumber(36));
        List<LottoNumber> lottoNumbers2 = Arrays.asList(new LottoNumber(1), new LottoNumber(12), new LottoNumber(33), new LottoNumber(44), new LottoNumber(15), new LottoNumber(7));
        List<Lotto> lottoList = Arrays.asList(new Lotto(lottoNumbers1), new Lotto(lottoNumbers2));
        LottoTickets tickets = new LottoTickets(lottoList);
        String winnerLottoInput = "1,12,33,44,15,36";

        LottoWinner lottoWinner = new LottoWinner(winnerLottoInput);
        LottoResult lottoResult = new LottoResult();
        lottoResult.calculateResult(tickets, lottoWinner);
        double expectedRevenueRate = (double) (1 * 2000000000 + 1 * 1500000) / (2 * 1000);
        assertThat(lottoResult.getRevenueRate()).isEqualTo(expectedRevenueRate);
    }

}
