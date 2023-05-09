package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

    @Test
    public void 로또_구입금액을_입력하면_구입금액에_해당하는_로또를_발행한다() {
        //given
        int money = 14000;
        LottoGenerator lottoGenerator = new LottoGenerator();
        //when
        lottoGenerator.generateLottoResultsFromMoney(money);
        List<int[]> lottoResults = lottoGenerator.getLottoResults();
        //then
        assertThat(lottoResults).hasSize(14);
        for (int[] lottoNum : lottoResults) {
            assertThat(lottoNum).hasSize(6);
        }
    }

    @Test
    public void 지난주_당첨번호를_입력하면_당첨통계를_제공한다() throws Exception {
        //given
        List<int[]> lottoResults = new ArrayList<>();
        int[] firstRound = { 2, 4, 6, 7, 10, 12 };
        int[] secondRound = { 1, 4, 6, 7, 10, 12 };
        int[] thirdRound = { 1, 2, 3, 4, 5, 6 };
        int[] fourthRound = { 1, 4, 5, 6, 15, 17 };
        int[] fifthRound = { 1, 3, 15, 17, 18, 19 };
        int[] sixthRound = { 1, 3, 15, 17, 29, 30 };
        int[] seventhRound = { 1, 3, 15, 17, 29, 31 };
        lottoResults.add(firstRound);
        lottoResults.add(secondRound);
        lottoResults.add(thirdRound);
        lottoResults.add(fourthRound);
        lottoResults.add(fifthRound);
        lottoResults.add(sixthRound);
        lottoResults.add(seventhRound);
        LottoResults results = new LottoResults(lottoResults);
        LottoGenerator lottoGenerator = new LottoGenerator(results);

        List<Integer> lastWeekLottoWinningNumbers = new ArrayList<>();
        lastWeekLottoWinningNumbers.add(1);
        lastWeekLottoWinningNumbers.add(3);
        lastWeekLottoWinningNumbers.add(15);
        lastWeekLottoWinningNumbers.add(17);
        lastWeekLottoWinningNumbers.add(29);
        lastWeekLottoWinningNumbers.add(31);
        //when
        WinningStatistics winningStatistics = lottoGenerator.calculateWinningStatistics(lastWeekLottoWinningNumbers);
        int[] result = winningStatistics.getWinningResults();
        //then
        assertThat(result[0]).isEqualTo(1);
        assertThat(result[1]).isEqualTo(1);
        assertThat(result[2]).isEqualTo(1);
        assertThat(result[3]).isEqualTo(1);
    }
}
