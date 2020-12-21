package lottery.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class TestLotteryGame {
    LotteryGame dummyLotteryGame;
    List<LotteryTicket> dummyLotteryTickets;
    List<LotteryTicket> dummyOneLotteryTicket;
    LotteryTicket dummyLotteryTicket;
    AutoBuyBehavior autoBuyBehavior;
    @BeforeEach
    void setUp() {
        autoBuyBehavior = new AutoBuyBehavior() {
            @Override
            public List<LotteryNumber> getLotteryNumbers(int pickCounts) {
                Collections.shuffle(lotteryAllNumbers);
                return new ArrayList<>(Arrays.asList(
                        LotteryNumber.of(5),
                        LotteryNumber.of(1),
                        LotteryNumber.of(4),
                        LotteryNumber.of(3),
                        LotteryNumber.of(2),
                        LotteryNumber.of(6)
                ));
            }
        };

        dummyLotteryGame = new LotteryGame(1000);

        dummyLotteryTicket = LotteryTicket.of(Arrays.asList(
                LotteryNumber.of(1),
                LotteryNumber.of(2),
                LotteryNumber.of(3),
                LotteryNumber.of(4),
                LotteryNumber.of(5),
                LotteryNumber.of(6)
        ));

        dummyOneLotteryTicket = new ArrayList<>(Arrays.asList(
                dummyLotteryTicket
        ));

        dummyLotteryTickets = new ArrayList<>(Arrays.asList(
                dummyLotteryTicket,
                dummyLotteryTicket
        ));
    }

    @Test
    @DisplayName("게임 규칙(구입가격)을 입력해서 로또 게임을 생성한다.")
    void createLotteryGame() {
        LotteryGame lotteryGame = new LotteryGame(1000);
        assertThat(lotteryGame)
                .isEqualTo(new LotteryGame(1000));
    }

    @ParameterizedTest
    @CsvSource({"1000,1","10000,10"})
    void buyNumberOfLotteryTickets(int cost, int expected) {
        LotteryGame lotteryGame = new LotteryGame(cost);
        assertThat(lotteryGame.buyNumberOfLotteryTickets())
                .isEqualTo(expected);
    }
}
