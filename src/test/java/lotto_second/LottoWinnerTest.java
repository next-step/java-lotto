package lotto_second;

import lotto_second.domain.LottoWinner;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoWinnerTest {

    @ParameterizedTest(name = "{index} ===> 올바르지 않은 큰 입력값 삽입 {0}")
    @ValueSource(strings = {"77,22,44,55", "1,3,3,4,2", "7,1,5,98,5,8,5", "9,3,8,8,7,6,51,22"})
    void winnerNumberBound(String input) {
        Class expect = IllegalArgumentException.class;

        assertThatThrownBy(() -> new LottoWinner(input, "45"))
                .isInstanceOf(expect);
    }

    @ParameterizedTest(name = "{index} ===> 올바르지 않은 당첨번호 입력값 삽입 {0}")
    @ValueSource(strings = {" ,22,44,55", "1,null,4,2,9,19"})
    void winnerNumberValid(String input) {
        Class expect = IllegalArgumentException.class;

        assertThatThrownBy(() -> new LottoWinner(input, "45"))
                .isInstanceOf(expect);
    }

    @ParameterizedTest(name = "{index} ===> 올바르지 않은 보너스번호 범위 삽입 {0}")
    @ValueSource(strings = {"7,1,4,98,5,8", "9,3,8,8,7,6,51"})
    void winnerNumberBound_2(String input) {
        Class expect = IllegalArgumentException.class;

        assertThatThrownBy(() -> new LottoWinner("1,2,3,4,5,6", input))
                .isInstanceOf(expect);
    }

    @ParameterizedTest(name = "{index} ===> 올바르지 않은 보너스번호 삽입 {0}")
    @ValueSource(strings = {"0", "46", "100"})
    void invalidBonusNumber(String input) {
        Class expect = IllegalArgumentException.class;

        assertThatThrownBy(() -> new LottoWinner("1,2,3,4,5,6", input))
                .isInstanceOf(expect);
    }
}
