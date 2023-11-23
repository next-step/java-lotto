package lotto.domain;

import lotto.enums.Rank;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TicketsTest {
    @Test
    void test_등수별카운드() {
        Tickets tickets = new Tickets(List.of(new Ticket(new Numbers("1, 2, 3, 4, 5, 6")), new Ticket(new Numbers("1, 2, 3, 4, 5, 45"))));
        Numbers winningNumbers = new Numbers("1, 2, 3, 4, 5, 6");

        EnumMap<Rank, Integer> countPerPrize = new EnumMap<>(Rank.class);
        countPerPrize.put(Rank.FIRST_PLACE, 1);
        countPerPrize.put(Rank.SECOND_PLACE, 1);
        for (Rank rank : Rank.values()) {
            countPerPrize.putIfAbsent(rank, 0);
        }

        assertThat(countPerPrize.toString()).isEqualTo(tickets.makeStatistics(winningNumbers).toString());
    }
}