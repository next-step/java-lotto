package lotto;

import lotto.domain.*;
import lotto.strategy.AutoLottoStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGameTest {

    public static final int COUNT = 2;


    @Test
    void gameStartAndcalculateReturnRate() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(new LottoTicket(Arrays.asList(1, 2, 3, 7, 8, 9)));
        tickets.add(new LottoTicket(Arrays.asList(11, 12, 13, 14, 15, 16)));

        LottoGame lottoGame = new LottoGame(new LottoTickets(tickets));
        GameResult gameResult = lottoGame.gameStart(winningNumbers);

        assertThat(gameResult.getResultStats().get(Rank.FOURTH)).isEqualTo(1);
        assertThat(gameResult.getResultStats().get(Rank.MISS)).isEqualTo(1);
        assertThat(gameResult.getReturnRate()).isEqualTo(2.5);

    }

}
