package lottery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestLotteryGame {
    @Test
    @DisplayName("게임 규칙(장당 가격, 뽑을 숫자)에 입력해서 로또 게임을 생성한다.")
    void createLotteryGame() {
        LotteryGame lotteryGame = new LotteryGame(1000, 6);
        assertThat(lotteryGame).isEqualTo(new LotteryGame(1000, 6));
    }

    @ParameterizedTest
    @CsvSource({"0,0","1000,1","10000,10"})
    void buyNumberOfLotteryTickets(int cost, int expected) {
        LotteryGame lotteryGame = new LotteryGame(1000, 6);
        assertThat(lotteryGame.buyNumberOfLotteryTickets(cost)).isEqualTo(expected);
    }

    @Test
    void buyNoLotteryTicket() {
        LotteryGame lotteryGame = new LotteryGame(1000, 6);
        assertThat(lotteryGame.buyLotteryTickets(0)).isEqualTo(new ArrayList<LotteryTicket>());
    }

    @Test
    void buyOneLotteryTicket() {
        LotteryGame lotteryGame = new LotteryGame(1000, 6) {
            @Override
            public List<LotteryTicket> buyLotteryTickets(int numberOfTickets) {
                List<LotteryTicket> lotteryTickets = new ArrayList<>();
                LotteryTicket lotteryTicket;
                for(int i = 0; i < numberOfTickets; i++) {
                    lotteryTicket = new LotteryTicket(new int[]{5, 1, 4, 3, 2, 6});
                    lotteryTickets.add(lotteryTicket);
                }
                return lotteryTickets;
            }
        };
        assertThat(lotteryGame.buyLotteryTickets(1)).isEqualTo(new ArrayList<LotteryTicket>(
                Arrays.asList(
                        new LotteryTicket(new int[]{5, 1, 4, 3, 2, 6}))
        ));
    }
}
