package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.domain.Lottery;
import step2.domain.LottoGame;
import step2.domain.WinningLottery;
import step2.util.Constants;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class LottoGameTest {

    private LottoGame lottoGame;

    private static Lottery[] lotteries = {
            new Lottery(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new Lottery(Arrays.asList(2, 3, 4, 5, 6, 7)),
            new Lottery(Arrays.asList(3, 4, 5, 6, 7, 8)),
            new Lottery(Arrays.asList(4, 5, 6, 7, 8, 9)),
            new Lottery(Arrays.asList(6, 7, 8, 9, 10, 45))
    };

    static List<Lottery> lotteryList() {
        return Arrays.asList(lotteries);
    }

    @BeforeEach
    void create_instance() {
        lottoGame = new LottoGame();
    }

    @ParameterizedTest
    @DisplayName("입력받은 구입 금액이 1000원 미만인 경우 예외 발생 테스트")
    @ValueSource(ints = {0, 300, 500, 900})
    void input_money_less_than_1000() {
        assertThatThrownBy(() -> lottoGame.buy(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.MONEY_IS_LESS_THAN_1000);
    }

    @ParameterizedTest
    @DisplayName("입력받은 구입 금액 만큼 로또를 구입하는지 테스트")
    @CsvSource(value = {"14000:14", "7000:7", "5000:5"}, delimiter = ':')
    void create_lottery_by_input_money(int money, int expected) {
        List<Lottery> lotteryList = lottoGame.buy(money);
        assertThat(lotteryList.size()).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("구매한 로또 묶음 당첨 여부 테스트")
    @MethodSource("lotteryList")
    void winning_test(List<Lottery> lotteryList) {
        WinningLottery winningLottery = new WinningLottery("1,2,3,4,5,6".split(","));
        Map<Lottery, Integer> matchedResult = lottoGame.matchLottery(lotteryList, winningLottery);
        assertThat(
                matchedResult.values()
                                .stream()
                                .map(Object::toString)
                                .collect(Collectors.joining(","))
        ).isEqualTo("6,5,4,3,1");
    }
}