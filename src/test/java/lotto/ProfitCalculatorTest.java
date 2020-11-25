package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.ProfitCalculator;
import lotto.domain.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfitCalculatorTest {

    @Test
    @DisplayName("로또목록으로 수익금을 계산한다")
    public void calculate_profit() {
        ProfitCalculator profitCalculator = new ProfitCalculator();
        Scanner scanner = new Scanner(Arrays.asList(1, 2, 3, 4, 5, 10));

        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(0, 2, 3, 4, 5, 6));
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(lottoTicket);
        scanner.scanAll(lottoTickets);

        assertThat(profitCalculator.calculateProfit(lottoTickets)).isEqualTo(50000);
    }
}
