package lotto;

import lotto.domain.InputConverter;
import lotto.domain.Lotto;
import lotto.domain.Store;
import lotto.domain.WinningStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

public class WinningStatisticsTest {
    @ParameterizedTest
    @CsvSource(value = {"\"46, 2, 3, 4, 5, 6\"", "\"1, 2, 3, 4, 5, 6, 8\"", "\"0, 2, 3, 4, 5, 6\""})
    @DisplayName("지난주 당첨번호 String -> List<Integer>로 변환")
    public void targetNumberCheck() {
        String strList = "1, 2, 3, 4, 5, 6";
        InputConverter inputConverter = new InputConverter();

        List<Integer> targetNumber = inputConverter.convertNumberToList(strList);

        WinningStatistics winningStatistics = new WinningStatistics(targetNumber);

        List<Integer> result = winningStatistics.showTargetNumber();

        assertThat(result).contains(1,2,3,4,5,6);
    }

    @ParameterizedTest
    @CsvSource(value = {"3000, 3", "4500, 4", "7000, 7"})
    @DisplayName("모든 로또 번호 확인")
    public void compareWithLastNumber(String budget, int expect) {
        Store store = new Store();
        List<Lotto> lottoBundle = store.purchase(budget);

        String strList = "1, 2, 3, 4, 5, 6";
        InputConverter inputConverter = new InputConverter();

        List<Integer> targetNumber = inputConverter.convertNumberToList(strList);

        WinningStatistics winningStatistics = new WinningStatistics(targetNumber);

        winningStatistics.compareWithTargetNumber(lottoBundle);

        for(int i = 0; i<expect; i++){
            assertThat(lottoBundle.get(i).getMatchNumber()).isLessThanOrEqualTo(6);
        }

    }

    @ParameterizedTest
    @CsvSource(value = {"3000, 3", "4500, 4", "7000, 7"})
    @DisplayName("로또 당첨 map 타입으로 반환")
    public void lottoResultTest(String budget, int expect) {
        Store store = new Store();
        List<Lotto> lottoBundle = store.purchase(budget);

        String strList = "1, 2, 3, 4, 5, 6";
        InputConverter inputConverter = new InputConverter();

        List<Integer> targetNumber = inputConverter.convertNumberToList(strList);

        WinningStatistics winningStatistics = new WinningStatistics(targetNumber);

        winningStatistics.compareWithTargetNumber(lottoBundle);
        Map<Integer, Integer> result = winningStatistics.lottoResult(lottoBundle);

        assertThat(result.size()).isEqualTo(7);

        assertAll("key 확인",
                () -> assertThat(result)
                        .overridingErrorMessage("The map doesn't contain the key: %s", 1)
                        .containsKey(1),

                () -> assertThat(result)
                        .overridingErrorMessage("The map doesn't contain the key: %s", 2)
                        .containsKey(2),

                () -> assertThat(result)
                        .overridingErrorMessage("The map doesn't contain the key: %s", 3)
                        .containsKey(3),

                () -> assertThat(result)
                        .overridingErrorMessage("The map doesn't contain the key: %s", 4)
                        .containsKey(4),

                () -> assertThat(result)
                        .overridingErrorMessage("The map doesn't contain the key: %s", 5)
                        .containsKey(5),

                () -> assertThat(result)
                        .overridingErrorMessage("The map doesn't contain the key: %s", 6)
                        .containsKey(6)
        );

    }



}
