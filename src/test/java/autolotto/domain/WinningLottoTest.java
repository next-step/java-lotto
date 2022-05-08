package autolotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest extends LottoNumbersFactory {

    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4 ,5, 6:3"}, delimiter = ':')
    void numberGiven_ReturnContainResult(String number, int compare) {
        assertThat(new WinningLotto(new LottoNumbers(of(number))).contains(LottoNumber.of(compare))).isTrue();
    }
}
