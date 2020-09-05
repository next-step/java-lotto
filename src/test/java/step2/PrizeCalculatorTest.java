package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.LottoTicket;
import step2.domain.PrizeCalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class PrizeCalculatorTest {

    private PrizeCalculator prizeCalculator = new PrizeCalculator();

    @DisplayName("수익률 계산 테스트")
    @Test
    void calculateProfitRatioTest(){
        List<Integer> officialWinningNumbers = new ArrayList<>();
        officialWinningNumbers.add(1);
        officialWinningNumbers.add(2);
        officialWinningNumbers.add(3);
        officialWinningNumbers.add(4);
        officialWinningNumbers.add(5);
        officialWinningNumbers.add(6);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(10);
        numbers.add(11);
        numbers.add(12);
        LottoTicket firstTicket = new LottoTicket(numbers);
        LottoTicket secondTicket = new LottoTicket(numbers);
        firstTicket.checkWinningTicket(officialWinningNumbers);
        secondTicket.checkWinningTicket(officialWinningNumbers);

        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(firstTicket);
        tickets.add(secondTicket);

        assertThat(prizeCalculator.calculateProfitRatio(tickets, 10000)).isEqualTo(1);

    }

}
