package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

class LottoGameTest {

    private LottoGame lottoGame;
    private List<Lottery> lotteryList;

    @BeforeEach
    void create_instance() {
        lottoGame = new LottoGame();
        lotteryList = make_lottery_list();
    }

    @ParameterizedTest
    @DisplayName("입력받은 구입 금액 만큼 로또 장수를 구매했는지 테스트")
    @CsvSource(value = {"14000:14", "7000:7", "5000:5"}, delimiter = ':')
    void create_lottery_by_input_money(int money, int expected) {
        List<Lottery> lotteryList = lottoGame.buy(new Money(money).getNumberOfLottery());
        assertThat(lotteryList.size()).isEqualTo(expected);
    }

    @Test
    @DisplayName("구매한 로또 묶음 당첨 여부 테스트")
    void winning_test() {
        WinningLottery winningLottery = new WinningLottery("1,2,3,4,5,6");
        Map<Lottery, Integer> matchedResult = lottoGame.matchLottery(lotteryList, winningLottery);

        String [] matchedValues = new String[lotteryList.size()];

        for (int i = 0; i < lotteryList.size(); i++) {
            matchedValues[i] = Integer.toString(matchedResult.get(lotteryList.get(i)));
        }

        assertThat(
                String.join(",", matchedValues)
        ).isEqualTo("4,0,3,0,0");
    }

    @Test
    @DisplayName("당첨 수익률 계산 테스트")
    void calculate_profit() {
        WinningLottery winningLottery = new WinningLottery("1,2,3,4,5,6");
        Map<Lottery, Integer> matchedResult = lottoGame.matchLottery(lotteryList, winningLottery);
        double profitRate = lottoGame.calculateProfit(5000 ,matchedResult);

        assertThat(profitRate).isEqualTo(11.0f);
    }

    List<Lottery> make_lottery_list() {
        Lottery[] lotteryArray = {
                new Lottery(
                        Arrays.asList(
                                new LottoNumber(1),
                                new LottoNumber(2),
                                new LottoNumber(3),
                                new LottoNumber(4),
                                new LottoNumber(34),
                                new LottoNumber(36)
                        )
                ),
                new Lottery(
                        Arrays.asList(
                                new LottoNumber(10),
                                new LottoNumber(15),
                                new LottoNumber(20),
                                new LottoNumber(25),
                                new LottoNumber(30),
                                new LottoNumber(35)
                        )
                ),
                new Lottery(
                        Arrays.asList(
                                new LottoNumber(1),
                                new LottoNumber(2),
                                new LottoNumber(6),
                                new LottoNumber(7),
                                new LottoNumber(8),
                                new LottoNumber(11)
                        )
                ),
                new Lottery(
                        Arrays.asList(
                                new LottoNumber(11),
                                new LottoNumber(12),
                                new LottoNumber(13),
                                new LottoNumber(14),
                                new LottoNumber(15),
                                new LottoNumber(16)
                        )
                ),
                new Lottery(
                        Arrays.asList(
                                new LottoNumber(22),
                                new LottoNumber(24),
                                new LottoNumber(26),
                                new LottoNumber(39),
                                new LottoNumber(40),
                                new LottoNumber(45)
                        )
                )
        };
        return Arrays.asList(lotteryArray);
    }
}