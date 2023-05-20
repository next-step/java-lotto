package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class WinnerTest {

    Winner winner = new Winner();
    List<Ticket> tickets = new ArrayList<>();

    @BeforeEach
    void init(){
        tickets.add(new Ticket(Arrays.asList(5, 18, 27, 34, 39, 45)));
        tickets.add(new Ticket(Arrays.asList(5, 10, 15, 19, 34, 36)));
        tickets.add(new Ticket(Arrays.asList(1, 4, 6, 24, 30, 41)));
        tickets.add(new Ticket(Arrays.asList(15, 27, 29, 36, 37, 42)));
        tickets.add(new Ticket(Arrays.asList(2, 6, 7, 9, 18, 42)));
        tickets.add(new Ticket(Arrays.asList(9, 17, 27, 28, 34, 45)));
        tickets.add(new Ticket(Arrays.asList(1, 14, 32, 33, 35, 43)));
        tickets.add(new Ticket(Arrays.asList(3, 5, 6, 33, 35, 43)));
        tickets.add(new Ticket(Arrays.asList(2, 4, 5, 6, 31, 41)));
    }

    @DisplayName("로또 한장당 숫자 n개 당첨 개수")
    @Test
    void 당첨_개수() {
        Map<Double, Integer> winnerMap = winner.findWinner(tickets, "1, 2, 3, 4, 5, 6", 7);
        assertThat(winnerMap.get(3)).isEqualTo(2);
        assertThat(winnerMap.get(4)).isEqualTo(1);
        assertThat(winnerMap.get(5)).isEqualTo(0);
        assertThat(winnerMap.get(6)).isEqualTo(0);
    }

}
