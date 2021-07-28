package lotto.domain;

import lotto.exception.OutOfRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {
    @DisplayName("생성자 테스트")
    @ValueSource(ints = {
            1, 45
    })
    @ParameterizedTest
    public void ctorTest(int number) {
        assertThat(new LottoNumber(number).intValue())
                .isEqualTo(number);
    }

    @DisplayName("생성자 테스트 - OutOfRangeException")
    @ValueSource(ints = {
            0, 46
    })
    @ParameterizedTest
    public void ctorTest_OutOfRangeException(int number) {
        assertThatThrownBy(() ->
            ctorTest(number)
        ).isInstanceOf(OutOfRangeException.class);
    }
}