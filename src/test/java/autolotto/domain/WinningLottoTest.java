package autolotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static autolotto.domain.LottoNumbersFactory.*;
import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4 ,5, 6:3"}, delimiter = ':')
    void numberGiven_ReturnContainResult(String number, int compare) {
        assertThat(new WinningLotto(new LottoNumbers(of(number)), LottoNumber.of(7)).contains(LottoNumber.of(compare))).isTrue();
    }
}
