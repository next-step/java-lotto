package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningTest {

    @Test
    @DisplayName("당첨 번호가 일치하는 숫자 개수를 반환하는지 확인")
    void checkContainsLottoNumber() {
        Set<Integer> winningNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers userLottoNumbers = new LottoNumbers(Arrays.asList(1, 11, 12, 13, 14, 15));

        Win win = new Win();
        int matchCount = win.countMatchingNumbers(winningNumbers, userLottoNumbers);
        assertThat(matchCount).isEqualTo(1);
    }

    @Test
    @DisplayName("당첨 수익률이 정확하게 반환되는지 확인")
    void calculateWinningRate() {

        int money = 14000;
        int totalWinningAmount = 5000;

        Win win = new Win();
        double winningRate = win.calculateWinningRate(money, totalWinningAmount);
        double formattedNumber = Math.floor(winningRate * 100) / 100;
        assertThat(formattedNumber).isEqualTo(0.35);
    }

}
