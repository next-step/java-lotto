package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WinningResultTest {

    List<LottoTicket> tickets = new ArrayList<>();
    List<WinningNumber> winningNumbers = new ArrayList<>();

    @BeforeEach
    void setUp() {
        tickets.add(new LottoTicket(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
        tickets.add(new LottoTicket(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7))));
        tickets.add(new LottoTicket(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 8))));
        tickets.add(new LottoTicket(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 9, 10))));
        tickets.add(new LottoTicket(new ArrayList<>(Arrays.asList(1, 2, 3, 11, 12, 13))));

        winningNumbers.add(new WinningNumber(1, false));
        winningNumbers.add(new WinningNumber(2, false));
        winningNumbers.add(new WinningNumber(3, false));
        winningNumbers.add(new WinningNumber(4, false));
        winningNumbers.add(new WinningNumber(5, false));
        winningNumbers.add(new WinningNumber(6, false));
        winningNumbers.add(new WinningNumber(7, true));
    }

    @Test
    void 모든_결과를_반환할_수_있다() {
        WinningResult winningResult = new WinningResult(tickets, winningNumbers);

        List<LottoResult> totalResult = winningResult.getTotalLottoResult();

        assertThat(totalResult).containsExactly(LottoResult.SIX_MATCHING,
            LottoResult.FIVE_MATCHING_BONUS, LottoResult.FIVE_MATCHING, LottoResult.FOUR_MATCHING,
            LottoResult.THREE_MATCHING);
    }
}