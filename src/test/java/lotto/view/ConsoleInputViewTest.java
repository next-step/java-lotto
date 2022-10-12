package lotto.view;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.domain.LottoNumber;

class ConsoleInputViewTest {
    @DisplayName("구분자(,)로 입력된 번호 문자열을 로또번호 객체로 변환한다.")
    @Test
    void lastLuckyNumber() {
        assertThat(consoleInputView("1,3,12,45,20,22").lastLuckyNumber()).isEqualTo(new LottoNumber(List.of(1, 12, 45, 20, 22, 3)));
    }

    @DisplayName("null 또는 공백문자열이 입력되면 IllegalArgumentException 예외를 발생시킨다.")
    @ParameterizedTest
    @NullSource
    @EmptySource
    void lastLuckyNumber_when_null_or_empty(String lottoNumber) {
        assertThatThrownBy(() -> consoleInputView(lottoNumber).lastLuckyNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Number cannot be null or blank and must be a delimiter(,)");
    }

    @DisplayName("번호 갯수가 6개가 아닌 번호 문자열이 입력되면 IllegalArgumentException 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = { "1,2,3,4,5", "1,2,3,4,5,6,7" })
    void of_when_invalid_count(String lottoNumber) {
        assertThatThrownBy(() -> consoleInputView(lottoNumber).lastLuckyNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Number's count must be six.");
    }

    @DisplayName("숫자가 아닌 번호 문자열이 입력되면 IllegalArgumentException 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = { "1,2,3,4,5,aa", "1,2,3,4,'',6", "1,2,3,4,,5" })
    void of_when_invalid_numbers(String lottoNumber) {
        assertThatThrownBy(() -> consoleInputView(lottoNumber).lastLuckyNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Only numbers between 1 and 45 are available.");
    }
    
    private ConsoleInputView consoleInputView(String lottoNumber) {
        return new MockConsoleInputView() {
            @Override
            String enteredLottoNumber() {
                return lottoNumber;
            }
        };
    }
}

abstract class MockConsoleInputView extends ConsoleInputView {}
