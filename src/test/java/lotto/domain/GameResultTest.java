package lotto.domain;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {

    @Test
    public void 로또_당첨_전체_금액_계산() {
        Ticket ticket = new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6)
                .stream()
                .map(i -> new LottoNo(i))
                .collect(Collectors.toList()));

        List<LottoNo> winningNos = Arrays.asList(1, 2, 3, 4, 5, 6)
                .stream()
                .map(i -> new LottoNo(i))
                .collect(Collectors.toList());

        List<Ticket> tickets = new ArrayList<>();
        tickets.add(ticket);

        GameResult gr = new GameResult(tickets, new WinningLotto(winningNos, new LottoNo(7)));
        int result = Money.calculateTotalAmount(gr.getLottoResults());
        assertThat(result).isEqualTo(2_000_000_000);
    }

    @Test
    public void 로또_수익률_계산() {
        BigDecimal result = Money.calculateBenefitRate(BigDecimal.valueOf(5000), BigDecimal.valueOf(14000));
        assertThat(result).isEqualTo(BigDecimal.valueOf(0.35));
    }

    @Test
    public void 로또_보너스볼_당첨_금액_확인() {
        Ticket ticket = new Ticket(Arrays.asList(1, 2, 3, 4, 5, 7)
                .stream()
                .map(i -> new LottoNo(i))
                .collect(Collectors.toList()));

        List<LottoNo> winningNos = Arrays.asList(1, 2, 3, 4, 5, 6)
                .stream()
                .map(i -> new LottoNo(i))
                .collect(Collectors.toList());

        List<Ticket> tickets = new ArrayList<>();
        tickets.add(ticket);

        WinningLotto winningNumber = new WinningLotto(winningNos, new LottoNo(7));
        GameResult gr = new GameResult(tickets, winningNumber);
        int result = Money.calculateTotalAmount(gr.getLottoResults());

        assertThat(result).isEqualTo(30_000_000);
    }
}