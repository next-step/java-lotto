package step3.lotto.domain.numbers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoWinningNumberTest {

    private static LottoWinningNumber winningNumbersTest;

    @Test
    void 숫자_체크_테스트() {
        assertThatThrownBy(() ->
                winningNumbersTest = new LottoWinningNumber("dfdf,dfdf,123,222,222,aaa", 1)
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    void empty체크() {
        assertThatThrownBy(() ->
                winningNumbersTest = new LottoWinningNumber("", 1)
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    void null체크() {
        assertThatThrownBy(() ->
                winningNumbersTest = new LottoWinningNumber(null, 1)
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 로또번호갯수_테스트() {
        assertThatThrownBy(() ->
                winningNumbersTest = new LottoWinningNumber("1,2,3,4,5,6,7", 1)
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 범위_테스트() {
        assertThatThrownBy(() ->
                winningNumbersTest = new LottoWinningNumber("10000,-100,3,4,5,6,7", 1)
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 보너스_번호와_로또번호_중복_테스트() {
        assertThatThrownBy(() ->
                winningNumbersTest = new LottoWinningNumber("1,2,3,4,5,6", 1)
        ).isInstanceOf(RuntimeException.class);
    }


}

