package lottery.domain;

import lottery.domain.strategy.Picker;
import lottery.domain.strategy.StaticPicker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LotteryTest {
    @DisplayName("정상 케이스")
    @ParameterizedTest
    @ValueSource(strings = {
            "1,2,3,4,5,6",
            "10,11,12,13,14,15",
            "40,41,42,43,44,45"
    })
    void validNumbers(String input) {
        final Picker picker = new StaticPicker(input);
        assertThatCode(() -> Lottery.from(picker))
                .doesNotThrowAnyException();
    }

    @DisplayName("갯수가 맞지 않는 케이스")
    @ParameterizedTest
    @ValueSource(strings = {
            "1,2,3,4,5",
            "1,2,3,4,5,6,7",
            "1,2,3,4,5,5",
            "1,2,3,4,5,6,6",
    })
    void invalidNumbers(String input) {
        final Picker picker = new StaticPicker(input);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lottery.from(picker));
    }

    @DisplayName("복권에 번호가 있는지 비교")
    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {
            "1,2,3,4,5,6 | 5 | true",
            "1,2,3,4,5,6 | 7 | false",
    })
    void hasNumber(String input, int number, boolean expected) {
        assertThat(
                Lottery.from(new StaticPicker(input)).hasNumber(LotteryNumber.valueOf(number))
        ).isEqualTo(expected);
    }
}
