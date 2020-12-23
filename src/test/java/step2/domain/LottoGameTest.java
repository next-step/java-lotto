package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.domain.Lottery;
import step2.domain.LottoGame;
import step2.domain.WinningLottery;
import step2.exception.IsLessThanTheMiminumAmountOfMoneyException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step2.domain.LottoGame.MONEY_IS_LESS_THAN_1000;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

class LottoGameTest {

    private LottoGame lottoGame;

    @BeforeEach
    void create_instance() {
        lottoGame = new LottoGame();
    }

    @ParameterizedTest
    @DisplayName("입력받은 구입 금액이 1000원 미만인 경우 예외 발생 테스트")
    @ValueSource(ints = {0, 300, 500, 900})
    void input_money_less_than_1000(int value) {
        assertThatThrownBy(() -> lottoGame.buy(new Money(value)))
                .isInstanceOf(IsLessThanTheMiminumAmountOfMoneyException.class)
                .hasMessageContaining(MONEY_IS_LESS_THAN_1000);
    }

    @ParameterizedTest
    @DisplayName("입력받은 구입 금액 만큼 로또 장수를 구매했는지 테스트")
    @CsvSource(value = {"14000:14", "7000:7", "5000:5"}, delimiter = ':')
    void create_lottery_by_input_money(int money, int expected) {
        List<Lottery> lotteryList = lottoGame.buy(new Money(money));
        assertThat(lotteryList.size()).isEqualTo(expected);
    }

    @Test
    @DisplayName("구매한 로또 묶음 당첨 여부 테스트")
    void winning_test() {
        Lottery[] lotteries = {
                new Lottery(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lottery(Arrays.asList(2, 3, 4, 5, 6, 7)),
                new Lottery(Arrays.asList(3, 4, 5, 6, 7, 8)),
                new Lottery(Arrays.asList(4, 5, 6, 7, 8, 9)),
                new Lottery(Arrays.asList(6, 7, 8, 9, 10, 45))
        };
        List<Lottery> lotteryList = Arrays.asList(lotteries);

        WinningLottery winningLottery = new WinningLottery("1,2,3,4,5,6");
        Map<Lottery, Integer> matchedResult = lottoGame.matchLottery(lotteryList, winningLottery);

        String [] matchedValues = new String[lotteryList.size()];

        for (int i = 0; i < lotteryList.size(); i++) {
            matchedValues[i] = Integer.toString(matchedResult.get(lotteryList.get(i)));
        }

        assertThat(
                String.join(",", matchedValues)
        ).isEqualTo("6,5,4,3,1");
    }

    @Test
    @DisplayName("당첨 수익률 계산 테스트")
    void calculate_profit() {
        Lottery[] lotteries = {
                new Lottery(Arrays.asList(1, 2, 3, 22, 34, 36)),
                new Lottery(Arrays.asList(10, 15, 20, 25, 30, 35)),
                new Lottery(Arrays.asList(1, 2, 6, 7, 8, 11, 12)),
                new Lottery(Arrays.asList(11, 12, 13, 14, 15, 16)),
                new Lottery(Arrays.asList(22, 24, 26, 39, 40, 45))
        };
        List<Lottery> lotteryList = Arrays.asList(lotteries);

        WinningLottery winningLottery = new WinningLottery("1,2,3,4,5,6");
        Map<Lottery, Integer> matchedResult = lottoGame.matchLottery(lotteryList, winningLottery);
        float profitRate = lottoGame.calculateProfit(5000 ,matchedResult);

        assertThat(profitRate).isEqualTo(2.0f);
    }
}