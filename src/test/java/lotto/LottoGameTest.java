package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.Rank;
import lotto.strategy.AutoLottoStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGameTest {

    public static final int COUNT = 2;
    LottoGame lottoGame;

    @DisplayName("로또번호는 6개로 생성된다")
    void generateAutoLottoNumbers() {

        LottoGame lottoGame = new LottoGame(LottoTickets.fromNumbers(COUNT));
        lottoGame.generateAutoLottoNumbers(new AutoLottoStrategy());

        assertThat(lottoGame.getTickets().getLottoTickets().size()).isEqualTo(COUNT);
        assertThat(lottoGame.getTickets().getLottoTickets().get(0).getLottoNumbers().size()).isEqualTo(6);
        assertThat(lottoGame.getTickets().getLottoTickets().get(1).getLottoNumbers().size()).isEqualTo(6);
    }

    @Test
    void gameStartAndcalculateReturnRate() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(new LottoTicket(Arrays.asList(1, 2, 3, 7, 8, 9)));
        tickets.add(new LottoTicket(Arrays.asList(11, 12, 13, 14, 15, 16)));

        LottoGame lottoGame = new LottoGame(new LottoTickets(tickets));
        lottoGame.gameStart(winningNumbers);

        double rate = lottoGame.calculateReturnRate();
        assertThat(lottoGame.getResults().get(Rank.FOURTH)).isEqualTo(1);
        assertThat(lottoGame.getResults().get(Rank.MISS)).isEqualTo(1);
        assertThat(lottoGame.calculateReturnRate()).isEqualTo(2.5);

    }

}
