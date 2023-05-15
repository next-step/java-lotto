package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class WinningStatisticsTest {

    @Test
    public void 로또_결과를_입력받으면_매칭_결과를_반환한다() {
        //given
        List<Integer> winningNumbers = new ArrayList<>();
        winningNumbers.add(1);
        winningNumbers.add(3);
        winningNumbers.add(15);
        winningNumbers.add(17);
        winningNumbers.add(21);
        winningNumbers.add(35);
        WinningStatistics winningStatistics = new WinningStatistics(winningNumbers);

        int[] fourthPrize = { 1, 3, 15, 7, 9, 11 };
        int[] thirdPrize = { 1, 3, 15, 17, 9, 11 };
        int[] secondPrize = { 1, 3, 15, 17, 9, 21 };
        int[] firstPrize = { 1, 3, 15, 17, 21, 35 };

        LottoNumber[] fourthPrizes = LottoNumber.fromIntegers(fourthPrize);
        LottoNumber[] thirdPrizes = LottoNumber.fromIntegers(thirdPrize);
        LottoNumber[] secondPrizes = LottoNumber.fromIntegers(secondPrize);
        LottoNumber[] firstPrizes = LottoNumber.fromIntegers(firstPrize);

        //when
        winningStatistics.matchCount(fourthPrizes);
        winningStatistics.matchCount(thirdPrizes);
        winningStatistics.matchCount(secondPrizes);
        winningStatistics.matchCount(firstPrizes);

        //then
        assertThat(winningStatistics.getWinningResults()[0]).isEqualTo(1);
        assertThat(winningStatistics.getWinningResults()[1]).isEqualTo(1);
        assertThat(winningStatistics.getWinningResults()[2]).isEqualTo(1);
        assertThat(winningStatistics.getWinningResults()[3]).isEqualTo(1);
        assertThat(winningStatistics.getTotalWinnings()).isEqualTo(2001555000);

    }
}
