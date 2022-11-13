package lotto;

import lotto.domain.WinningNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumberTest {

    @Test
    void 우승번호를_받아_생성한다() {
        Integer[] numbers = {1,2,3,4,5,6};
        WinningNumber winningNumber = new WinningNumber(numbers);

        List<Integer> numbersList = Arrays.asList(1,2,3,4,5,6);

        assertThat(winningNumber.same(numbersList)).isTrue();
    }

    @Test
    void 당첨갯수를_센다() {
        Integer[] winning = {1,2,3,4,5,6};
        List<Integer> tryLotto = Arrays.asList(1,2,3,7,8,10);
        WinningNumber winningNumber = new WinningNumber(winning);

        assertThat(winningNumber.countWinning(tryLotto)).isEqualTo(3);
    }
}
