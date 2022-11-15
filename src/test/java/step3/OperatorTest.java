package step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class OperatorTest {

    @ParameterizedTest
    @DisplayName("몇 등인지 확인")
    @CsvSource(value = {
            "1:true:NOT_RANK",
            "1:false:NOT_RANK",
            "2:ture:NOT_RANK",
            "2:false:NOT_RANK",
            "3:true:THREE",
            "3:false:THREE",
            "4:true:FOUR",
            "4:false:FOUR",
            "5:false:FIVE",
            "5:true:FIVE_BONUS",
            "6:false:SIX",
            "6:true:SIX"
    }, delimiter = ':')
    void find(int count, boolean bonus, Operator operator) {
        assertThat(Operator.find(count, bonus)).isEqualTo(operator);
    }
}
