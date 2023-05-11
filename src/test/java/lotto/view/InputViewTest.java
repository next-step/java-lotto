package lotto.view;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InputViewTest {

    List<Integer> lastWeekWinningNumber = new ArrayList<>();

    @BeforeAll
    void setUp() {
        lastWeekWinningNumber.add(1);
        lastWeekWinningNumber.add(2);
        lastWeekWinningNumber.add(3);
        lastWeekWinningNumber.add(4);
        lastWeekWinningNumber.add(5);
        lastWeekWinningNumber.add(6);
    }

    @Test
    void hasLottoNumbers() {
        assertThat(InputView.hasLottoNumbers(lastWeekWinningNumber, 6)).isTrue();
        assertThat(InputView.hasLottoNumbers(lastWeekWinningNumber, 7)).isFalse();
    }

    @Test
    void isNotWithinLotteryNumberRange() {
        assertThat(InputView.isNotWithinLotteryNumberRange(5)).isFalse();
        assertThat(InputView.isNotWithinLotteryNumberRange(45)).isFalse();
        assertThat(InputView.isNotWithinLotteryNumberRange(55)).isTrue();
    }

}
