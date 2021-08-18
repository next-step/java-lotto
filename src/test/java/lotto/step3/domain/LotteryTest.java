package lotto.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LotteryTest {
    @Test
    @DisplayName("로또 번호가 6개가 아닐 때 예외 발생")
    void isValidLottery() {
        Set<LottoNumber> lottery = new HashSet<>();
        lottery.add(new LottoNumber(1));
        lottery.add(new LottoNumber(10));
        lottery.add(new LottoNumber(11));
        lottery.add(new LottoNumber(21));
        lottery.add(new LottoNumber(31));
        lottery.add(new LottoNumber(41));
        lottery.add(new LottoNumber(42));
        assertThrows(IllegalArgumentException.class, () -> new Lottery(lottery));
    }

    @Test
    @DisplayName("로또 번호가 6개일 때 예외가 발생하지 않는다.")
    void isValidLottery2() {
        Set<LottoNumber> lottery = new HashSet<>();
        lottery.add(new LottoNumber(1));
        lottery.add(new LottoNumber(10));
        lottery.add(new LottoNumber(11));
        lottery.add(new LottoNumber(21));
        lottery.add(new LottoNumber(31));
        lottery.add(new LottoNumber(41));
        assertDoesNotThrow(() -> new Lottery(lottery));
    }

    @Test
    @DisplayName("로또 번호가 중복 되면 예외가 발생한다.")
    void isValidLottery3() {
        Set<LottoNumber> lottery = new HashSet<>();
        lottery.add(new LottoNumber(1));
        lottery.add(new LottoNumber(2));
        lottery.add(new LottoNumber(3));
        lottery.add(new LottoNumber(4));
        lottery.add(new LottoNumber(5));
        lottery.add(new LottoNumber(5));
        assertThrows(IllegalArgumentException.class, () -> new Lottery(lottery));
    }

    @Test
    @DisplayName("당첨 번호와 6개 일치 ")
    void matchWinningNumber() {
        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        Lottery lottery = new Lottery(new HashSet<>(lottoNumbers));
        Winning winning = new Winning(new Lottery(new HashSet<>(
                Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)))), new LottoNumber(7)
        );
        assertThat(lottery.matchWinningNumber(winning)).isEqualTo(6);
    }

    @Test
    @DisplayName("당첨 번호와 5개 일치 ")
    void matchWinningNumber2() {
        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        Lottery lottery = new Lottery(new HashSet<>(lottoNumbers));
        Winning winning = new Winning(new Lottery(new HashSet<>(
                Arrays.asList(new LottoNumber(11), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)))), new LottoNumber(7)
        );
        assertThat(lottery.matchWinningNumber(winning)).isEqualTo(5);
    }

    @Test
    @DisplayName("당첨 번호와 4개 일치 ")
    void matchWinningNumber3() {
        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        Lottery lottery = new Lottery(new HashSet<>(lottoNumbers));
        Winning winning = new Winning(new Lottery(new HashSet<>(
                Arrays.asList(new LottoNumber(11), new LottoNumber(12), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)))), new LottoNumber(7)
        );
        assertThat(lottery.matchWinningNumber(winning)).isEqualTo(4);
    }

    @Test
    @DisplayName("당첨 번호와 3개 일치 ")
    void matchWinningNumber4() {
        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        Lottery lottery = new Lottery(new HashSet<>(lottoNumbers));
        Winning winning = new Winning(new Lottery(new HashSet<>(
                Arrays.asList(new LottoNumber(11), new LottoNumber(12), new LottoNumber(3), new LottoNumber(14), new LottoNumber(5), new LottoNumber(6)))), new LottoNumber(7)
        );
        assertThat(lottery.matchWinningNumber(winning)).isEqualTo(3);
    }

    @Test
    @DisplayName("당첨 번호 와 보너스 볼 일치 ")
    void isContainBonusBall() {
        List<LottoNumber> lottoNumber = Arrays.asList(new LottoNumber(10), new LottoNumber(12), new LottoNumber(13), new LottoNumber(14), new LottoNumber(15), new LottoNumber(16));
        Lottery lottery = new Lottery(new HashSet<>(lottoNumber));

        List<LottoNumber> winningNumber = Arrays.asList(new LottoNumber(10), new LottoNumber(12), new LottoNumber(13), new LottoNumber(23), new LottoNumber(24), new LottoNumber(16));
        Winning winning = new Winning(new Lottery(new HashSet<>(winningNumber)), new LottoNumber(15));
        assertThat(lottery.containBonus(winning)).isTrue();

    }

    @Test
    @DisplayName("당첨 번호 와 보너스 볼 일치 하지 않음")
    void isContainBonusBall2() {
        List<LottoNumber> lottoNumber = Arrays.asList(new LottoNumber(5), new LottoNumber(15), new LottoNumber(25), new LottoNumber(30), new LottoNumber(31), new LottoNumber(32));
        Lottery lottery = new Lottery(new HashSet<>(lottoNumber));

        List<LottoNumber> winningNumber = Arrays.asList(new LottoNumber(10), new LottoNumber(15), new LottoNumber(20), new LottoNumber(25), new LottoNumber(31), new LottoNumber(32));
        Winning winning = new Winning(new Lottery(new HashSet<>(winningNumber)), new LottoNumber(6));
        assertThat(lottery.containBonus(winning)).isFalse();

    }

}