package lotto_auto;

import lotto_auto.domain.Lotto;
import lotto_auto.domain.LottoNumber;
import lotto_auto.domain.LottoTickets;
import lotto_auto.service.LottoResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoResultTest {
    private LottoTickets tickets;
    private String winnerLottoInput;

    @BeforeEach
    public void setUp() {
        List<LottoNumber> lottoNumbers1 = Arrays.asList(new LottoNumber(1), new LottoNumber(12), new LottoNumber(33), new LottoNumber(44), new LottoNumber(15), new LottoNumber(36));
        List<LottoNumber> lottoNumbers2 = Arrays.asList(new LottoNumber(1), new LottoNumber(12), new LottoNumber(33), new LottoNumber(44), new LottoNumber(15), new LottoNumber(7));
        List<Lotto> lottoList = Arrays.asList(new Lotto(lottoNumbers1), new Lotto(lottoNumbers2));
        tickets = new LottoTickets(lottoList);
        winnerLottoInput = "1,12,33,44,15,36";
    }

    @DisplayName("로또 당첨결과 통계 확인")
    @Test
    public void countOfMatch() {
        LottoResult lottoResult = new LottoResult(tickets, winnerLottoInput);
        assertThat(lottoResult.getCountOfMatch(6)).isEqualTo(1);
        assertThat(lottoResult.getCountOfMatch(5)).isEqualTo(1);
        assertThat(lottoResult.getCountOfMatch(4)).isEqualTo(0);
        assertThat(lottoResult.getCountOfMatch(3)).isEqualTo(0);
    }

    @DisplayName("로또 당첨결과 수익률 확인")
    @Test
    public void getRevenueRate() {
        LottoResult lottoResult = new LottoResult(tickets, winnerLottoInput);
        double expectedRevenueRate = (double) (1 * 2000000000 + 1 * 1500000) / (2 * 1000);
        assertThat(lottoResult.getRevenueRate()).isEqualTo(expectedRevenueRate);
    }

}
