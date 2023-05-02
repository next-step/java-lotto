package lotto;

import lotto.domain.WinningStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

public class WinningStatisticsTest {
    @Test
    @DisplayName("지난주 당첨번호 String -> List<Integer>로 변환")
    public void targetNumberCheck() {
        WinningStatistics winningStatistics = new WinningStatistics("1, 2, 3, 4, 5, 6");
        List<Integer> result = winningStatistics.showTargetNumber();

        assertThat(result).contains(1,2,3,4,5,6);
    }



}
