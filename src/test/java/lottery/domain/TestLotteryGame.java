package lottery.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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
                        new LotteryNumber(5),
                        new LotteryNumber(1),
                        new LotteryNumber(4),
                        new LotteryNumber(3),
                        new LotteryNumber(2),
                        new LotteryNumber(6)
                ));
            }
        };

        dummyLotteryGame = new LotteryGame(1000);

        dummyLotteryTicket = LotteryTicket.of(Arrays.asList(
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
        LotteryGame lotteryGame = new LotteryGame(1000);
        assertThat(lotteryGame)
                .isEqualTo(new LotteryGame(1000));
    }

    @Test
    @DisplayName("구입금액이 0원이면 에러 발생")
    void buyNoLotteryTickets() {
        LotteryGame lotteryGame = new LotteryGame(1000);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lotteryGame.buyNumberOfLotteryTickets(0);
        });
    }

    @ParameterizedTest
    @CsvSource({"1000,1","10000,10"})
    void buyNumberOfLotteryTickets(int cost, int expected) {
        LotteryGame lotteryGame = new LotteryGame(1000);
        assertThat(lotteryGame.buyNumberOfLotteryTickets(cost))
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("로또 티켓을 구매하지 못한 경우 테스트")
    void buyNoLotteryTicket() {
        LotteryGame lotteryGame = new LotteryGame(1000);
        assertThat(lotteryGame.buyLotteryTickets(0, autoBuyBehavior))
                .isEqualTo(new LotteryTickets(new ArrayList<>()));
    }

    @Test
    @DisplayName("로또 티켓을 한장 구매 테스트")
    void buyOneLotteryTicket() {
        assertThat(dummyLotteryGame.buyLotteryTickets(1, autoBuyBehavior))
                .isEqualTo(new LotteryTickets(new ArrayList<>(Arrays.asList(LotteryTicket.of("5,1,4,3,2,6")))));
    }
}
