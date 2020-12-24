package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchedResultTest {

    private LottoGame lottoGame;
    private List<Lottery> lotteryList;

    @BeforeEach
    void before_each() {
        lottoGame = new LottoGame();
        lotteryList = make_lottery_list();
    }

    @Test
    @DisplayName("일치하는 복권 갯수를 구하는 테스트 (복권 당첨 등수 테스트)")
    void get_count() {
        WinningLottery winningLottery = new WinningLottery("1,2,3,4,5,6");
        MatchedResult matchedResult = lottoGame.matchLottery(lotteryList, winningLottery);

        assertThat(matchedResult.getCount(Prize.FIRST.getMatched())).isEqualTo(1);
        assertThat(matchedResult.getCount(Prize.SECOND.getMatched())).isEqualTo(1);
        assertThat(matchedResult.getCount(Prize.THIRD.getMatched())).isEqualTo(1);
        assertThat(matchedResult.getCount(Prize.FIRST.getMatched())).isEqualTo(1);
        assertThat(matchedResult.getCount(Prize.NONE.getMatched())).isEqualTo(1);
    }

    @Test
    @DisplayName("당첨 금액 계산 테스트")
    void get_profit() {
        WinningLottery winningLottery = new WinningLottery("1,2,3,4,30,40");
        MatchedResult matchedResult = lottoGame.matchLottery(lotteryList, winningLottery);
        assertThat(matchedResult.getProfit()).isEqualTo(55_000);
    }

    List<Lottery> make_lottery_list() {
        Lottery[] lotteryArray = {
                new Lottery(
                        Arrays.asList(
                                new LottoNumber(1),
                                new LottoNumber(2),
                                new LottoNumber(3),
                                new LottoNumber(4),
                                new LottoNumber(5),
                                new LottoNumber(6)
                        )
                ),
                new Lottery(
                        Arrays.asList(
                                new LottoNumber(2),
                                new LottoNumber(3),
                                new LottoNumber(4),
                                new LottoNumber(5),
                                new LottoNumber(6),
                                new LottoNumber(7)
                        )
                ),
                new Lottery(
                        Arrays.asList(
                                new LottoNumber(3),
                                new LottoNumber(4),
                                new LottoNumber(5),
                                new LottoNumber(6),
                                new LottoNumber(7),
                                new LottoNumber(8)
                        )
                ),
                new Lottery(
                        Arrays.asList(
                                new LottoNumber(4),
                                new LottoNumber(5),
                                new LottoNumber(6),
                                new LottoNumber(7),
                                new LottoNumber(8),
                                new LottoNumber(9)
                        )
                ),
                new Lottery(
                        Arrays.asList(
                                new LottoNumber(7),
                                new LottoNumber(8),
                                new LottoNumber(9),
                                new LottoNumber(11),
                                new LottoNumber(33),
                                new LottoNumber(45)
                        )
                )
        };
        return Arrays.asList(lotteryArray);
    }
}
