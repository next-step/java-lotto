package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class TicketsTest {

        @Test
        void 로또_결과_수익률_계산() {
                long purchaseAmount = 3_000;
                WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
                int[][] lottoNumbers = {{1, 2, 3, 7, 8, 9}, {10, 11, 12, 13, 14, 15}, {1, 2, 3, 4, 10, 11}};
                Tickets tickets = new Tickets(lottoNumbers);

                tickets.analyzeLottoResults(winningNumbers, purchaseAmount);

                assertThat(tickets.rateOfBenefit()).isEqualTo(18.33);
        }
}
