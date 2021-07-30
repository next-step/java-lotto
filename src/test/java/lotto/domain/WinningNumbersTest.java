package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningNumbersTest {

    @DisplayName("1~45까지의 당첨 번호 입력")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "15,20,30,34,1,9"})
    void winningNumbers_당첨번호_입력(String input) {
        assertThat(new WinningNumbers(input)).isInstanceOf(WinningNumbers.class);
    }

    @DisplayName("입력한 번호가 1~45 사이가 아닐때 예외 throw")
    @ParameterizedTest
    @ValueSource(strings = {"-5,2,3,4,5,6", "15,20,30,46,1,9"})
    void winningNumbers_범위를_벗어난_번호(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinningNumbers(input);
        }).withMessageMatching("1부터 45의 숫자가 아닌 문자가 포함되어 있습니다.");
    }

    @DisplayName("입력한 번호가 6개가 아닐때 예외 throw")
    @ParameterizedTest
    @ValueSource(strings = {"5,2,3,4,6", "15,20,30,43,1,9,17"})
    void winningNumbers_입력한_번호가_6개가_아님(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinningNumbers(input);
        }).withMessageMatching("6개의 숫자를 등록해야 합니다.");
    }

    @DisplayName("숫자가 아닌 문자 입력시 예외 throw")
    @ParameterizedTest
    @ValueSource(strings = {"a,2,3,4,6,10", "15,20,30,43,1,가"})
    void winningNumbers_숫자가_아닌_문자_입력(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinningNumbers(input);
        }).withMessageMatching("1부터 45의 숫자가 아닌 문자가 포함되어 있습니다.");
    }

}
