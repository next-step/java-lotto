package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class WinningNumbersTest {

    @Test
    public void 보너스숫자가_주어졌을_때_포함관계를_확인할_수_있다(){
        //given
        List<LottoNumber> lastWeekWinning = new ArrayList<>(Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4), new LottoNumber(5),
                new LottoNumber(6)));
        WinningNumbers winningNumbers = new WinningNumbers(lastWeekWinning, new LottoNumber(9));
        //when
        //then
        assertTrue(winningNumbers.containsBonusNumber(new LottoNumber(9)));
    }
}