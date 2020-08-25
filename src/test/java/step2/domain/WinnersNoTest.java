package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import step1.NullableConverter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinnersNoTest {

    @ParameterizedTest
    @CsvSource(value = {"1,7,3:3"}, delimiter = ':')
    void getWinnersResultNo(String input, int result) {
        assertThat(WinnersNo.getWinnersResultNo(input).size()).isEqualTo(result);
    }

    @DisplayName("숫자 검증")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:46", "null:43", "1,2,3,4,!!,6:43"}, delimiter = ':')
    public void validate_winnerno_fail_illegalArgumentException(@ConvertWith(NullableConverter.class) String input, int bonusNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> WinnersNo.ofWinnersNo(bonusNumber, input));
    }
}
