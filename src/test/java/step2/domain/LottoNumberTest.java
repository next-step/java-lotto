package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.exception.IllegalLottoNumberException;

class LottoNumberTest {


    @DisplayName("로또번호 숫자 허용범위 내 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9,10})
    void lottoNumberRangeTest(int number) {
        Assertions.assertDoesNotThrow(() -> new LottoNumber(number));
    }

    @DisplayName("로또번호 숫자 허용범위 내 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0,52,53,54,55,46,47,48,49})
    void lottoNumberOverRangeTest(int number) {
        Assertions.assertThrows(IllegalLottoNumberException.class, () -> new LottoNumber(number));
    }

}