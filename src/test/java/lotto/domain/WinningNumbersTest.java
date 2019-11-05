package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kohyusik on 05/11/2019.
 */
public class WinningNumbersTest {

    private WinningNumbers winningNumbers;

    @BeforeEach
    void setUp() {
        // given
        winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("당첨여부 계산")
    @Test
    void generate() {

        // given
        List<LotteryTicket> tickets = new ArrayList<>();
        tickets.add(new LotteryTicket(Arrays.asList(1, 2, 3, 4, 5, 6))); // first
        tickets.add(new LotteryTicket(Arrays.asList(1, 2, 3, 4, 5, 45))); // second
        tickets.add(new LotteryTicket(Arrays.asList(1, 2, 3, 4, 44, 45))); // third
        tickets.add(new LotteryTicket(Arrays.asList(1, 2, 3, 43, 44, 45))); // fourth
        tickets.add(new LotteryTicket(Arrays.asList(1, 2, 42, 43, 44, 45))); // none

        // when
        Map<WinningRanking, Long> countingMap = winningNumbers.getWinningTickets(tickets);
        System.out.println(countingMap);

        // then
        assertThat(countingMap).hasSize(4);

    }
}
