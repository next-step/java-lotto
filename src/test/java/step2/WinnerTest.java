package step2;

import org.junit.jupiter.api.BeforeEach;
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
    
    @Test
    void 당첨_개수() {
        Map<Integer, Integer> winnerMap = winner.findWinner(tickets, "1, 2, 3, 4, 5, 6");
        assertThat(winnerMap.get(3)).isEqualTo(2);
        assertThat(winnerMap.get(4)).isEqualTo(1);
        assertThat(winnerMap.get(5)).isEqualTo(0);
        assertThat(winnerMap.get(6)).isEqualTo(0);
    }

    /*@ParameterizedTest(name = "{0} 개 당첨된 사람 : {1}명")
    @MethodSource("parameter")
    void 당첨_개수(int matchCount, int winnerCount) {
        Winner winner = new Winner();
        Map<Integer, Integer> winnerMap = winner.findWinner(tickets, "1, 2, 3, 4, 5, 6");
        assertThat(winnerMap.get(matchCount)).isEqualTo(winnerCount);
    }

    static Stream<Arguments> parameter(){
        return Stream.of(
                arguments(3,2)
                ,arguments(4,1)
                ,arguments(5,0)
                ,arguments(6,0)
        );
    }*/
}
