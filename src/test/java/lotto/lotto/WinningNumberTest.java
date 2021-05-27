package lotto.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {
    @Test
    @DisplayName("보너스 넘버가 중복 될 경우 에러")
    void contains() {
        //given
        Set<LottoNumber> numbers = new HashSet<>();
        numbers.add(new LottoNumber(1));
        WinningNumber winningNumber = new WinningNumber(numbers);
        LottoNumber bonusNumber = new LottoNumber(1);
        //when
        boolean contains = winningNumber.contains(bonusNumber);
        //then
        assertThat(contains).isTrue();
    }
}