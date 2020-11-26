package lottery.domain;

import lottery.domain.strategy.Picker;
import lottery.domain.strategy.StaticPicker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class WinningNumberTest {
    WinningNumber winningNumber = WinningNumber.from(new StaticPicker("11,12,13,14,15,16,17"));

    @DisplayName("정상 케이스")
    @ParameterizedTest
    @ValueSource(strings = {
            "1,2,3,4,5,6,7",
            "10,11,12,13,14,15,16",
            "39,40,41,42,43,44,45"
    })
    void validNumbers(String input) {
        final Picker picker = new StaticPicker(input);
        assertThatCode(() -> WinningNumber.from(picker))
                .doesNotThrowAnyException();
    }

    @DisplayName("갯수가 맞지 않는 케이스")
    @ParameterizedTest
    @ValueSource(strings = {
            "1,2,3,4,5,6",
            "1,2,3,4,5,6,7,8",
            "1,2,3,4,5,6,6",
            "1,2,3,4,5,6,7,7",
    })
    void invalidNumbers(String input) {
        final Picker picker = new StaticPicker(input);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningNumber.from(picker));
    }

    @DisplayName("매칭 결과")
    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {
            "  LOSE | 21,22,23,24,25,26",
            "  LOSE | 11,22,23,24,25,26",
            "  LOSE | 11,12,23,24,25,26",
            " FIFTH | 11,12,13,24,25,26",
            "FOURTH | 11,12,13,14,25,26",
            "FOURTH | 11,12,13,14,25,17",
            " THIRD | 11,12,13,14,15,26",
            "SECOND | 11,12,13,14,15,17",
            " FIRST | 11,12,13,14,15,16",
    })
    void countMatched(WinningType winningType, String input) {
        final Picker picker = new StaticPicker(input);
        final Lottery lottery = Lottery.from(picker);
        assertThat(winningNumber.countMatched(lottery)).isEqualTo(winningType);
    }
}
