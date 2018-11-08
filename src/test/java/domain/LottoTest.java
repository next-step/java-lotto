package domain;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoTest {

    @Test
    public void 구매한_티켓_수_카운트_테스트() {
        Lotto lotto = new Lotto();
        int result = lotto.countTicket(14000);
        assertThat(result).isEqualTo(14);
    }

    @Test
    public void 로또티켓과_당첨번호가_몇개_일치하는지_테스트() {
        Ticket ticket = new Ticket(Arrays.asList(1, 3, 5, 14, 22, 45));
        Ticket winningNumber = new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6));

        int result = ticket.getCountOfMatches(winningNumber);
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 수익률_계산() {
        Map<Integer, Integer> lottoResults = new HashMap<>();
        lottoResults.put(3, 1);
        lottoResults.put(4, 0);
        lottoResults.put(5, 0);
        lottoResults.put(6, 0);

        GameResult gameResult = new GameResult(lottoResults, 14000);

        BigDecimal result = gameResult.calculateBenefitRate();
        assertThat(result).isEqualTo(BigDecimal.valueOf(0.35));
    }

    @Test
    public void 로또_당첨_전체_금액_계산() {
        Map<Integer, Integer> lottoResults = new HashMap<>();
        lottoResults.put(3, 1);
        lottoResults.put(4, 1);
        lottoResults.put(5, 0);
        lottoResults.put(6, 0);

        GameResult gameResult = new GameResult(lottoResults, 14000);

        int result = gameResult.calculateTotalAmount();
        assertThat(result).isEqualTo(55000);
    }

}