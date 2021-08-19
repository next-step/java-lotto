package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class StatisticsTest {

    List<LottoPaper> lottoPapers;
    WinningLottoNumber winningLottoNumber;

    @BeforeEach
    public void init() {
        lottoPapers = Arrays.asList(
                new LottoPaper(
                        new LottoNumberStragey(){
                            @Override
                            public Set<Integer> getLottoNumber() {
                                return new HashSet<>(Arrays.asList(1,2,3,4,5,6));
                            }
                        }
                )
        );

        winningLottoNumber = new WinningLottoNumber();
        winningLottoNumber.setWinningNumber("1,2,3,4,5,6");
    }

    @DisplayName("당첨 금액 테스트")
    @Test
    public void earnMoneyTest() {
        Statistics statistics = new Statistics();
        statistics.calculateWinningResult(lottoPapers, winningLottoNumber);
        assertThat(statistics.getEarnMoney()).isEqualTo(Rank.FIRST.getWinningMoney());
    }

    @DisplayName("당첨 개수 테스트")
    @Test
    public void matchCountTest() {
        Statistics statistics = new Statistics();
        statistics.calculateWinningResult(lottoPapers, winningLottoNumber);
        assertThat(statistics.winningCount(Rank.FIRST)).isEqualTo(1);
    }

}