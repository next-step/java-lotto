package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class LottoLotteryTest {

    private Map<Integer, Integer> lottoStatistic = new HashMap<>();

    @BeforeEach
    void setUp() {
        lottoStatistic.put(1, 2);
        lottoStatistic.put(2, 2);
        lottoStatistic.put(3, 2);
        lottoStatistic.put(4, 0);
        lottoStatistic.put(5, 1);
        lottoStatistic.put(6, 0);

    }
    @DisplayName("당첨과 관계 없는 값 삭제")
    @Test
    void removeUnavailableValueTest() {
        for (int i = 1; i < Lotto.WINNING_NUMBERS_LENGTH + 1; i++) {
            LottoLottery.removeUnavailableValue(lottoStatistic, i);
        }
        assertThat(lottoStatistic.size()).isEqualTo(2);
    }

    @DisplayName("당첨 금액 확인")
    @Test
    void totalWinningPrize() {
        double totalWard = 0;
        for(int i = LottoLottery.MATCHING_LIMIT; i < Lotto.WINNING_NUMBERS_LENGTH +1; i++){
            totalWard += lottoStatistic.get(i) * Prize.findByCountOfMatch(i).getWinningMoney();
        }
        double testTotalWard = LottoLottery.totalPrize(lottoStatistic);
        assertThat(testTotalWard).isEqualTo(totalWard);
    }
}
