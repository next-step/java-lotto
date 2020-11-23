package step2.lotto.automatic.domain;

import org.junit.jupiter.api.Test;
import step2.lotto.automatic.domain.numbers.LottoWinningNumber;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoWinningNumberTest {

    private static LottoWinningNumber winningNumbersTest;

    @Test
    void 숫자_체크_테스트() {
        assertThatThrownBy(() ->
                winningNumbersTest = new LottoWinningNumber("dfdf,dfdf,123,222,222,aaa")
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    void empty체크() {
        assertThatThrownBy(() ->
                winningNumbersTest = new LottoWinningNumber("")
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    void null체크() {
        assertThatThrownBy(() ->
                winningNumbersTest = new LottoWinningNumber(null)
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 로또번호갯수_테스트() {
        assertThatThrownBy(() ->
                winningNumbersTest = new LottoWinningNumber("1,2,3,4,5,6,7")
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 범위_테스트() {
        assertThatThrownBy(() ->
                winningNumbersTest = new LottoWinningNumber("10000,-100,3,4,5,6,7")
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 전체적인_테스트() {
        List<Integer> testList = new ArrayList<>();
        winningNumbersTest = new LottoWinningNumber("1,2,3,4,5,6");

        for (int i = 1; i <= 6; i++) {
            testList.add(i);
        }

        assertThat(winningNumbersTest.getRank(testList)).isEqualTo(1);
    }
}

