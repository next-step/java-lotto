package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfitCalculatorTest {
    @Test
    void calculate() {
        LottoTicket ticket6 = new LottoTicket(new int[]{1, 2, 3, 4, 5, 6});
        LottoTicket ticket3 = new LottoTicket(new int[]{1, 2, 3, 14, 15, 16});

        List<LottoResult> results = new ArrayList<>();
        results.add(new LottoResult(ticket6, new MatchCount(0)));
        results.add(new LottoResult(ticket3, new MatchCount(3)));
        assertThat(ProfitCalculator.calculate(results)).isEqualTo(2.5f);
    }
}
