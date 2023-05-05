package lottery.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import lottery.domain.constant.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WinningStatisticsTest {

    private final Map<Rank, Integer> lotteriesByRank = new HashMap<>();

    @BeforeEach
    void setUp() {
        lotteriesByRank.put(Rank.FIRST, 0);
        lotteriesByRank.put(Rank.SECOND, 1);
        lotteriesByRank.put(Rank.THIRD, 2);
        lotteriesByRank.put(Rank.FOURTH, 5);
    }

    @Test
    @DisplayName("순위에 해당하는 모든 키값이 존재하는 맵 일 경우 객체를 생성한다.")
    void createObjTest() {
        assertDoesNotThrow(() -> new WinningStatistics(lotteriesByRank));
    }

    @Test
    @DisplayName("1등 부터 4등 에 당첨된 로또 갯수를 반환한다.")
    void numberOfRanksTest() {
        WinningStatistics winningStatistics = new WinningStatistics(lotteriesByRank);
        assertAll(
                () -> assertEquals(winningStatistics.getWinningNumbers(Rank.FIRST), 0, "1등"),
                () -> assertEquals(winningStatistics.getWinningNumbers(Rank.SECOND), 1, "2등"),
                () -> assertEquals(winningStatistics.getWinningNumbers(Rank.THIRD), 2, "3등"),
                () -> assertEquals(winningStatistics.getWinningNumbers(Rank.FOURTH), 5, "4등")
        );
    }

    @Test
    @DisplayName("최종 로또 당첨 수령 금액을 반환한다.")
    void totalWinningPriceTest() {
        assertThat(new WinningStatistics(lotteriesByRank).getTotalWinningPrice())
                .isEqualTo(1_625_000);
    }

    @ParameterizedTest(name = "로또 구매 금액 대비 수령금액 을 1을 기준으로 반환한다.")
    @CsvSource(value = {"1625:1.0"},delimiter = ':')
    void returnOnInvestmentTest(int lotteries, double expectedReturn) {
        assertThat(new WinningStatistics(lotteriesByRank).returnOnInvestment(lotteries))
                .isEqualTo(expectedReturn);
    }

}
