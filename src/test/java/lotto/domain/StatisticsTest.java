package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class StatisticsTest {

    List<LottoPaper> lottoPaper;
    WinningLottoNumber winningLottoNumber;
    Statistics statistics;

    @BeforeEach
    public void init() {
        statistics = new Statistics();
        lottoPaper = new ArrayList<>();
        winningLottoNumber = new WinningLottoNumber();
        lottoPaper.add(new LottoPaper(
                new LottoNumberStragey(){
                    @Override
                    public Set<Integer> getLottoNumber() {
                        return new HashSet<>(Arrays.asList(1,2,3,4,5,6));
                    }
                }
        ));
        winningLottoNumber.setWinningNumber("1,2,3,4,5,6");
        statistics.calculateWinningResult(lottoPaper,winningLottoNumber);
    }

    @DisplayName("당첨 개수 확인 테스트")
    @Test
    public void statisticMatchTest() {
        assertThat(statistics.winningCount(WinnigResult.FIRST)).isEqualTo(1);
    }

    @DisplayName("당첨 금액 테스트")
    @Test
    public void earnMoneyTest() {
        assertThat(statistics.getEarnMoney()).isEqualTo(WinnigResult.FIRST_EARN_MONEY);
    }

}