package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTest {

    @Test
    @DisplayName("6개의 값이 일치하면 6개일치한 값이 1 증가한다.")
    void when_ThreeNumbersAreMatched() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lottery lottery = new Lottery(List.of(1, 2, 3, 4, 5, 6));

        Lotteries lotteries = new Lotteries(lottery, winningNumbers);
        List<Integer> result = lotteries.calculateResult(winningNumbers);

        assertThat(result).hasSize(1).contains(6);
    }

    @DisplayName("2등을 추첨을 위해 보너스 볼(추가번호)을 하나 더 추첨한다.")
    @Test
    void input_bonus_ball() {
        Lottery lottery = new Lottery(List.of(1, 2, 3, 4, 5, 6));

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 7);
        int bonusNumber = 6;
        boolean matchResult = lottery.matchWithBonusBall(winningNumbers, bonusNumber);

        assertThat(matchResult).isTrue();
    }
}