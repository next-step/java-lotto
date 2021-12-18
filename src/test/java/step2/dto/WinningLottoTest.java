package step2.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.domain.MatchedNumber;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {
    
    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4, 5, 6 : 6", "10, 13, 4, 5, 34, 40 : 13", "3, 33, 42, 34, 35, 23 : 23"})
    @DisplayName("지난 당첨번호와 보너스볼 번호가 중복일시 예외를 던진다")
    public void duplicateException(String text, int input) {
        assertThatThrownBy(() -> {
            new WinningLotto(new MatchedNumber(text), input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
