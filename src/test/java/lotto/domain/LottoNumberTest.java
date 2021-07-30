package lotto.domain;

import lotto.exception.OutOfRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {
    @DisplayName("생성자 테스트")
    @ValueSource(ints = {
            1, 45
    })
    @ParameterizedTest
    public void ctorTest(int number) {
        //noinspection
        assertThatCode(() ->
                new LottoNumber(number)
        ).doesNotThrowAnyException();
    }

    @DisplayName("생성자 테스트 - OutOfRangeException")
    @ValueSource(ints = {
            0, 46
    })
    @ParameterizedTest
    public void ctorTest_OutOfRangeException(int number) {
        assertThatThrownBy(() ->
                new LottoNumber(number)
        ).isInstanceOf(OutOfRangeException.class);
    }
}