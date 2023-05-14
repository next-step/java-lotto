package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    List<Integer> lastWeekWinningNumber;

    final int bonusBallNumber = 7;


    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        lastWeekWinningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    void isMatchedBonusNumber() {
        assertThat(LottoMachine.isMatchedBonusNumber(Arrays.asList(1,2,3,4,5,7), lastWeekWinningNumber, bonusBallNumber)).isTrue();
        assertThat(LottoMachine.isMatchedBonusNumber(Arrays.asList(1,2,3,4,5,7), lastWeekWinningNumber, 8)).isFalse();
    }


    @Test
    void createLotto() {
        assertThat(LottoMachine.createLotto(new LottoNumber(Arrays.asList(1,2,3,4,5,6))).getNumbers().getList()).hasSize(6);
    }

    @Test
    void getMatchedCount() {
        assertThat(LottoMachine.getMatchedCount(Arrays.asList(1,2,3,4,5,6), lastWeekWinningNumber)).isEqualTo(6);
    }

    @Test
    void createLottoNumbers() {
        assertThat(LottoMachine.createLottoNumbers().getNumbers().getList()).hasSize(6);
    }

    @Test
    void hasLottoNumbers() {
        assertThat(LottoMachine.hasLottoNumbers(lastWeekWinningNumber, 6)).isTrue();
        assertThat(LottoMachine.hasLottoNumbers(lastWeekWinningNumber, 7)).isFalse();
    }

    @Test
    void isNotWithinLotteryNumberRange() {
        assertThat(LottoMachine.isNotWithinLotteryNumberRange(5)).isFalse();
        assertThat(LottoMachine.isNotWithinLotteryNumberRange(45)).isFalse();
        assertThat(LottoMachine.isNotWithinLotteryNumberRange(55)).isTrue();
    }

}
