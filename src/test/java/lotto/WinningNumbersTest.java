package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class WinningNumbersTest {
    private WinningNumbers winningNumbers;

    @BeforeEach
    void setUp() {
        String numbers = "1,2,3,4,5,6";
        winningNumbers = new WinningNumbers(numbers);
    }

    @DisplayName("입력받은 당첨번호 null 체크")
    @ParameterizedTest
    @NullAndEmptySource
    void isNullCheck(String input) {
        winningNumbers.isNullCheck(input);
    }

    @DisplayName("입력받은 당첨번호 1~45 범위 체크")
    @ParameterizedTest
    @CsvSource(value = {"-1000:false", "bacd:false", "0.456:false", "46:false", "15:true"}, delimiter = ':')
    void checkWinningNumbersRange(String input, boolean expected) {
        boolean result = winningNumbers.checkWinningNumbersRange(input);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("입력받은 당첨번호 6자리 체크")
    @ParameterizedTest
    @CsvSource(value = {"7:false", "0:false", "6:true", "3:false"}, delimiter = ':')
    void checkWinningNumberDigit(int length, boolean expected) {
        boolean result = winningNumbers.checkWinningNumberDigit(length);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("입력받은 문자열 당첨번호 쉼표로 구분하기")
    @ParameterizedTest
    @ValueSource(strings = {"3,4,5,45,2,1"})
    void splitWinningNumbers(String input) {
        String[] numbers = winningNumbers.splitWinningNumbers(input);
        assertThat(numbers).containsExactly("3","4","5","45","2","1");
    }

    @DisplayName("입력받은 문자열 당첨번호 쉼표로 구분 예외 확인")
    @ParameterizedTest
    @ValueSource(strings = {"3,4,5/145,2,1", "3,4:5,145,2,1"})
    void splitWinningNumbersException(String input) {
        assertThatThrownBy(() -> {
            new WinningNumbers(input);
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("당첨번호는 쉼표(,)로 구분되어야합니다.");
    }

    @DisplayName("문자열 배열을 Integer List 변환")
    @ParameterizedTest
    @ValueSource(strings = {"3,4,5,45,2,1"})
    void changeStringArrayToIntegerList(String input) {
        String[] numbers = winningNumbers.splitWinningNumbers(input);
        List<Integer> numberList = winningNumbers.changeStringArrayToIntegerList(numbers);
        assertThat(numberList).contains(Integer.parseInt(numbers[0]));
    }
}