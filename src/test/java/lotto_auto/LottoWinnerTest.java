package lotto_auto;

import lotto_auto.domain.LottoWinner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoWinnerTest {

    @DisplayName("올바르지않은 당첨번호 입력값 기준보다 작게 작성")
    @ParameterizedTest
    @ValueSource(strings = {"77,22,44,55", "1,3,3,4,2", "7,1,5,98,5,8,5", "9,3,8,8,7,6,51,22"})
    void winnerNumberBound(String input) {
        Class expect = IllegalArgumentException.class;

        assertThatThrownBy(() -> new LottoWinner(input))
                .isInstanceOf(expect);
    }

    @DisplayName("올바르지않은 당첨번호 입력값")
    @ParameterizedTest
    @ValueSource(strings = {" ,22,44,55", "1,null,4,2,9,19"})
    void winnerNumberValid(String input) {
        Class expect = IllegalArgumentException.class;
        String expectedMsg = "올바르지 않은 당첨번호입니다";

        assertThatThrownBy(() -> new LottoWinner(input))
                .isInstanceOf(expect);
    }

    @DisplayName("올바르지않은 당첨번호 입력값 당첨범위 벗어남")
    @ParameterizedTest
    @ValueSource(strings = {"7,1,4,98,5,8", "9,3,8,8,7,6,51"})
    void winnerNumberBound_2(String input) {
        Class expect = IllegalArgumentException.class;
        String expectedMsg = "올바르지 않은 로또의 범위";

        assertThatThrownBy(() -> new LottoWinner(input))
                .isInstanceOf(expect);
    }
}
