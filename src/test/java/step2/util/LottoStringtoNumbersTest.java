package step2.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class LottoStringtoNumbersTest {

    @Test
    @DisplayName("구입한 로또 대비 당첨된 개수")
    void convertStringtoNumbers() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoStringtoNumbers.convertStringtoNumbers("1,e,10,20,30,40"));
    }
}