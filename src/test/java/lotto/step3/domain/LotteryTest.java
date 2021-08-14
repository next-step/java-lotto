package lotto.step3.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Lottery(lottery));
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
        Assertions.assertDoesNotThrow(() -> new Lottery(lottery));
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
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Lottery(lottery));
    }

}