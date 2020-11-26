package domain.lottery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestLotteryGame {
    LotteryGame dummyLotteryGame;
    List<LotteryTicket> dummyLotteryTickets;
    List<LotteryTicket> dummyOneLotteryTicket;
    LotteryTicket dummyLotteryTicket;
    @BeforeEach
    void setUp() {
        dummyLotteryGame = new LotteryGame(1000, 6) {
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

        dummyLotteryTicket = new LotteryTicket(Arrays.asList(
                new LotteryNumber(1),
                new LotteryNumber(2),
                new LotteryNumber(3),
                new LotteryNumber(4),
                new LotteryNumber(5),
                new LotteryNumber(6)
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
    @DisplayName("게임 규칙(장당 가격, 뽑을 숫자)에 입력해서 로또 게임을 생성한다.")
    void createLotteryGame() {
        LotteryGame lotteryGame = new LotteryGame(1000, 6);
        assertThat(lotteryGame)
                .isEqualTo(new LotteryGame(1000, 6));
    }

    @ParameterizedTest
    @CsvSource({"0,0","1000,1","10000,10"})
    void buyNumberOfLotteryTickets(int cost, int expected) {
        LotteryGame lotteryGame = new LotteryGame(1000, 6);
        assertThat(lotteryGame.buyNumberOfLotteryTickets(cost))
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("로또 티켓을 구매하지 못한 경우 테스트")
    void buyNoLotteryTicket() {
        LotteryGame lotteryGame = new LotteryGame(1000, 6);
        assertThat(lotteryGame.buyLotteryTickets(0))
                .isEqualTo(new ArrayList<LotteryTicket>());
    }

    @Test
    @DisplayName("로또 티켓을 한장 구매 테스트")
    void buyOneLotteryTicket() {
        assertThat(dummyLotteryGame.buyLotteryTickets(1))
                .isEqualTo(new ArrayList<>(
                        Arrays.asList(new LotteryTicket(new int[]{5, 1, 4, 3, 2, 6}))
                ));
    }

    @Test
    @DisplayName("로또 게임 결과 로또 당첨번호와 맞지 않는 경우")
    void matchNoNumbersWithOneLotteryTickets() {
        assertThat(dummyLotteryGame.matchLotteryTickets("7,8,9,10,11,12", dummyOneLotteryTicket))
                .isEqualTo(new LotteryResult(0,1));
    }

    @Test
    @DisplayName("로또 게임 결과 로또 당첨번호와 3개 일치하는 경우")
    void matchThreeNumbersWithOneLotteryTickets() {
        assertThat(dummyLotteryGame.matchLotteryTickets("1,2,3,10,11,12", dummyOneLotteryTicket))
                .isEqualTo(new LotteryResult(3,1));
    }

    @Test
    @DisplayName("로또 게임 결과 로또 당첨번호화 6개가 2개의 티켓에서 일치하는 경우")
    void matchSixNumbersWithMultiLotteryTickets() {
        assertThat(dummyLotteryGame.matchLotteryTickets("1,2,3,4,5,6", dummyLotteryTickets))
                .isEqualTo(new LotteryResult(6,2));
    }
}
