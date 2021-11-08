package lotto.domains;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,5,2,10,32,43"})
    void 당첨번호_생성(String numbers) {
        WinningNumber winningNumber = new WinningNumber(numbers);

        assertThat(winningNumber).isEqualTo(
                new WinningNumber(Lists.newArrayList(1, 5, 2, 10, 32, 43)));
    }

    @Test
    void 일치하는_번호_개수_찾기() {
        WinningNumber winningNumber = new WinningNumber("1, 2, 3, 4, 5, 6");
        Lotto lotto = new Lotto(Lists.newArrayList(1, 2, 3, 4, 5, 10));

        int result = winningNumber.numOfWinningNumberMatchCnt(lotto);

        assertThat(result).isEqualTo(5);
    }
}