package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketTest {
    private List<Game> games;
    private Set<Integer> lottoNumbers;

    @BeforeEach
    void setUp() {
        OfficialLotto officialLotto = new OfficialLotto(3, 6);
        lottoNumbers = officialLotto.getUniques(4);
        games = new ArrayList<>();
        games.add(new Game(4));
        games.add(new Game(5));
        games.add(new Game(6));
    }

    @Test
    @DisplayName("게임들의 당첨결과 조회")
    void name() {
        Ticket ticket = new Ticket(games, lottoNumbers, 6);
        assertThat(ticket.report()).isEqualTo(new int[]{0, 0, 1, 1, 1, 0});

    }
}
