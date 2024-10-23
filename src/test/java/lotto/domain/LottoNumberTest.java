package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {46, 0})
    void checkLottoNumber테스트(int testLottoNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoNumber lottoNumber = new LottoNumber(testLottoNumber);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"6,6,true","6,7,false"})
    void checkLottoNumber테스트(int testLottoNumber, int expectedLottoNumber, boolean expectedResult) {
            LottoNumber lottoNumber = new LottoNumber(testLottoNumber);
            assertThat(lottoNumber.compareNumber(expectedLottoNumber)).isEqualTo(expectedResult);

    }

}