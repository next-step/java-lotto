package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketTest {
    private List<Game> games;
    private Winning winning;

    @BeforeEach
    void setUp() {
        Set<Integer> lottoNumbers = new HashSet<>();
        lottoNumbers.add(1);
        lottoNumbers.add(2);
        lottoNumbers.add(3);
        lottoNumbers.add(4);
        lottoNumbers.add(5);
        winning = new Winning(lottoNumbers);
        games = new ArrayList<>();
        games.add(new Game(5, 5));
    }

    @Test
    @DisplayName("게임들의 당첨결과 조회")
    void name() {
        Ticket ticket = new Ticket(games);
        assertThat(ticket.scores(winning, 5)).isEqualTo(new int[]{0, 0, 0, 0, 0, 1});

    }
}
