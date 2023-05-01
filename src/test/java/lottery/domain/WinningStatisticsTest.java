package lottery.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import lottery.domain.constant.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningStatisticsTest {

    private final Map<Rank, Integer> lotteriesByRank = new HashMap<>();

    private final Map<Rank, Integer> emptyLotteries = new HashMap<>();

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
    @DisplayName("순위에 해당하는 모든 키값이 존재하지 않는 맵 일 경우 익셉션을 발생한다.")
    void createObjErrorTest() {
        assertThatThrownBy(() -> new WinningStatistics(emptyLotteries))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨을 판별 할 수 있는 키 정보가 없습니다.");
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
}
