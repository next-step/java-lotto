package lotto;

import lotto.model.*;
import lotto.model.Winning;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningTest {
    @Test
    void evaluateBonus() {
        Winning winning = new Winning(new Lottery(), 6);
        Lottery lottery = new Lottery(Lottery.toLotteryNumbers(Arrays.asList(1,2,3,4,5,6)));
        assertThat(winning.bonus(lottery.lotteryNumbers).isPresent()).isTrue();
    }
}
