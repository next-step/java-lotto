package lotto;

import lotto.model.Lottery;
import lotto.model.LotteryBox;
import lotto.model.Reward;
import lotto.model.Winning;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTest {
    Lottery lottery = new Lottery();

    @Test
    void create45NumbersInBox() {
        assertThat(LotteryBox.numbers).hasSize(45);
    }

    @Test
    void numbersInBoxShouldBeUnique() {
        int actual = new HashSet<>(LotteryBox.numbers).size();
        int expected = LotteryBox.numbers.size();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void generate6Numbers() {
        assertThat(lottery.lotteryNumbers).hasSize(6);
    }

    @Test
    void shuffledBoxShouldDifferWithOrigin() {
        List<Integer> origin = new ArrayList(LotteryBox.numbers);
        LotteryBox.shuffleBox();
        assertThat(LotteryBox.numbers).isNotEqualTo(origin);
    }

    @Test
    void shouldFindSixNumbers() {
        assertThat(LotteryBox.createLottery()).hasSize(6);
        assertThat(lottery.lotteryNumbers).hasSize(6);
    }

    @Test
    void findWin() {
        Lottery lottery = new Lottery(Lottery.toLotteryNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Winning winning = new Winning(new Lottery(Lottery.toLotteryNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))),7);
        assertThat(lottery.findWin(winning)).isEqualTo(Reward.of(6, false));
    }

    @Test
    void toLotteryNumbersReturnTreeSet() {
        assertThat(Lottery.toLotteryNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))).isInstanceOf(TreeSet.class);
    }

    @Test
    void LotteryShouldNotHaveDuplicatedNumber() {
        Lottery lottery = new Lottery(Lottery.toLotteryNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 6)));
        assertThat(lottery.lotteryNumbers).hasSize(6);
    }

    @Test
    void evaluateBonus() {
        Lottery lottery = new Lottery(Lottery.toLotteryNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 6)));
        assertThat(lottery.bonus(1).isPresent()).isTrue();
    }
}
