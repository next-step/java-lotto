package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class PrizeCalculatorTest {

    private LottoTicket lottoTicket;
    private PrizeCalculator prizeCalculator;
    private List<LottoTicket> tickets;
    private List<Integer> officialWinningNumbers = new ArrayList<>();
    private int bonusNumber;

    @BeforeEach
    public void init() {
        prizeCalculator = new PrizeCalculator();

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            numbers.add(i);
            officialWinningNumbers.add(i);
        }
        lottoTicket = new LottoTicket(numbers);
        bonusNumber = 8;
        lottoTicket.checkWinningTicket(officialWinningNumbers, bonusNumber);
        tickets = new ArrayList<>();
        tickets.add(lottoTicket);
    }

    @Test
    public void 수익률_계산_태스트() {
        assertThat(prizeCalculator.calculateProfitRatio(tickets, 1000)).isEqualTo(2000000.0);
    }
}
