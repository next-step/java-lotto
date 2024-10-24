package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoSettingsTest {

    @ParameterizedTest
    @CsvSource(value = {"5,false","6,true"},delimiter = ',')
    void 로또_사이즈_검증(int size,boolean result) {
        assertThat(LottoSettings.isValidSize(size)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "0,false", "45,true", "46,false"}, delimiter = ',')
    void 로또_숫자_범위_검증(int value, boolean result) {
        assertThat(LottoSettings.isNumberInValidRange(value)).isEqualTo(result);
    }
}
