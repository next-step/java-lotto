package domain;

import static domain.WinningStatistics.WINNING_PRIZES;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class WinningAnalyzerTest {

    @Test
    public void 지난주_당첨번호를_입력하면_당첨통계를_제공한다() throws Exception {
        //given
        List<int[]> lottoList = new ArrayList<>();
        int[] firstRound = { 2, 4, 6, 7, 10, 12 };
        int[] secondRound = { 1, 4, 6, 7, 10, 12 };
        int[] thirdRound = { 1, 2, 3, 4, 5, 6 };
        int[] fourthRound = { 1, 4, 5, 6, 15, 17 };
        int[] fifthRound = { 1, 3, 15, 17, 18, 19 };
        int[] sixthRound = { 1, 3, 15, 17, 29, 30 };
        int[] seventhRound = { 1, 3, 15, 17, 29, 31 };
        lottoList.add(firstRound);
        lottoList.add(secondRound);
        lottoList.add(thirdRound);
        lottoList.add(fourthRound);
        lottoList.add(fifthRound);
        lottoList.add(sixthRound);
        lottoList.add(seventhRound);
        LottoResults lottoResults = new LottoResults(lottoList);

        List<Integer> winningNumbers = new ArrayList<>();
        winningNumbers.add(1);
        winningNumbers.add(3);
        winningNumbers.add(15);
        winningNumbers.add(17);
        winningNumbers.add(29);
        winningNumbers.add(31);
        WinningAnalyzer winningAnalyzer = new WinningAnalyzer(lottoResults, winningNumbers);
        //when
        WinningStatistics winningStatistics = winningAnalyzer.calculateWinningStatistics();
        int[] result = winningStatistics.getWinningResults();
        //then
        assertThat(result[0]).isEqualTo(1);
        assertThat(result[1]).isEqualTo(1);
        assertThat(result[2]).isEqualTo(1);
        assertThat(result[3]).isEqualTo(1);
    }

    @Test
    void 수익률을_반환한다() {
        //given
        List<int[]> lottoList = new ArrayList<>();
        int[] firstRound = { 2, 4, 6, 7, 10, 12 };
        int[] secondRound = { 1, 4, 6, 7, 10, 12 };
        int[] thirdRound = { 1, 2, 3, 4, 5, 6 };
        int[] fourthRound = { 1, 4, 5, 6, 15, 17 };
        int[] fifthRound = { 1, 3, 15, 17, 18, 19 };
        int[] sixthRound = { 1, 3, 15, 17, 29, 30 };
        int[] seventhRound = { 1, 3, 15, 17, 29, 31 };
        lottoList.add(firstRound);
        lottoList.add(secondRound);
        lottoList.add(thirdRound);
        lottoList.add(fourthRound);
        lottoList.add(fifthRound);
        lottoList.add(sixthRound);
        lottoList.add(seventhRound);
        LottoResults lottoResults = new LottoResults(lottoList);

        List<Integer> winningNumbers = new ArrayList<>();
        winningNumbers.add(1);
        winningNumbers.add(3);
        winningNumbers.add(15);
        winningNumbers.add(17);
        winningNumbers.add(29);
        winningNumbers.add(31);
        WinningAnalyzer winningAnalyzer = new WinningAnalyzer(lottoResults, winningNumbers);
        WinningStatistics winningStatistics = winningAnalyzer.calculateWinningStatistics();
        //when
        float roi = winningAnalyzer.getReturnOnInvestment(7000);
        float expectedResult = WINNING_PRIZES.stream().mapToInt(prize -> prize.getPrizeMoney()).sum() / 7000;
        //then
        assertThat(areFloatsEqual(roi, expectedResult)).isTrue();
    }

    private static boolean areFloatsEqual(float a, float b) {
        float epsilon = 1f;
        return Math.abs(a - b) <= epsilon;
    }


}
