package lotto.domain;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

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
    public void 로또_당첨_전체_금액_계산() {
        int result = GameResult.calculateTotalAmount(new int[]{13, 0, 0, 1, 0, 0, 0});
        assertThat(result).isEqualTo(5_000);
    }

    @Test
    public void 로또_수익률_계산() {
        BigDecimal result = GameResult.calculateBenefitRate(BigDecimal.valueOf(5000), BigDecimal.valueOf(14000));
        assertThat(result).isEqualTo(BigDecimal.valueOf(0.35));
    }
}