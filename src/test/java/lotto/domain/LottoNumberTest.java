package lotto.domain;

import lotto.exception.NumberRangeExceededException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @ParameterizedTest
    @DisplayName("로또 번호 생성 예외 테스트")
    @ValueSource(ints = {-1, 0, 46})
    void createLottoNumber(int number) {
        assertThrows(NumberRangeExceededException.class, () -> new LottoNumber(number));
    }

}