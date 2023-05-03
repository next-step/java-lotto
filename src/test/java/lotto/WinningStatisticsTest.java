package lotto;

import lotto.domain.InputConverter;
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
        String strList = "1, 2, 3, 4, 5, 6";
        InputConverter inputConverter = new InputConverter();

        List<Integer> targetNumber = inputConverter.convertNumberToList(strList);

        WinningStatistics winningStatistics = new WinningStatistics(targetNumber);

        List<Integer> result = winningStatistics.showTargetNumber();

        assertThat(result).contains(1,2,3,4,5,6);
    }

    @Test
    @DisplayName("모든 로또 번호 확인")
    public void compareWithLastNumber() {

    }


}
