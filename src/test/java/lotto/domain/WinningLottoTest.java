package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @Test
    @DisplayName("당첨번호 일치하는 번호 갯수 계산")
    void matchingWinningNumberCount(){

        Lotto lotto = new Lotto(List.of(
                new LottoNumbers(List.of(1, 3, 5, 7, 19, 41)), // 4개 일치
                new LottoNumbers(List.of(1, 3, 6, 8, 20, 30)), // 2개 일치
                new LottoNumbers(List.of(2, 4, 6, 8, 10, 12)), // 2개 일치
                new LottoNumbers(List.of(6, 7, 8, 9, 10, 11)), // 1개 일치
                new LottoNumbers(List.of(1, 6, 8, 9, 20, 21)), // 1개 일치
                new LottoNumbers(List.of(10, 17, 18, 19, 20, 31)), // 0개 일치
                new LottoNumbers(List.of(17, 27, 28, 29, 30, 41)), // 0개 일치
                new LottoNumbers(List.of(19, 23, 28, 31, 40, 44))  // 0개 일치
        ));

        List<Integer> lastWinningNumbers = List.of(1, 2, 3, 4, 5, 7);

        WinningLotto winningLotto = new WinningLotto(lotto, lastWinningNumbers);

        Map<Integer, Integer> winningCounts = (Map<Integer, Integer>) winningLotto.winningResult().get("winningCounts");

        assertThat(winningCounts.get(0)).isEqualTo(3);
        assertThat(winningCounts.get(1)).isEqualTo(2);
        assertThat(winningCounts.get(2)).isEqualTo(2);
        assertThat(winningCounts.get(4)).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률 계산")
    void calculateRateOfReturn(){
        Lotto lotto = new Lotto(List.of(
                new LottoNumbers(List.of(1, 3, 5, 7, 19, 41)), // 4개 일치
                new LottoNumbers(List.of(1, 3, 6, 8, 20, 30)), // 2개 일치
                new LottoNumbers(List.of(2, 4, 6, 8, 10, 12)), // 2개 일치
                new LottoNumbers(List.of(6, 7, 8, 9, 10, 11)), // 1개 일치
                new LottoNumbers(List.of(1, 6, 8, 9, 20, 21)), // 1개 일치
                new LottoNumbers(List.of(10, 17, 18, 19, 20, 31)), // 0개 일치
                new LottoNumbers(List.of(17, 27, 28, 29, 30, 41)), // 0개 일치
                new LottoNumbers(List.of(19, 23, 28, 31, 40, 44))  // 0개 일치
        ));

        List<Integer> lastWinningNumbers = List.of(1, 2, 3, 4, 5, 7);

        WinningLotto winningLotto = new WinningLotto(lotto, lastWinningNumbers);
        double rateOfReturn = (double) winningLotto.winningResult().get("rateOfReturn");

        assertThat(rateOfReturn).isEqualTo(6250);
    }
}