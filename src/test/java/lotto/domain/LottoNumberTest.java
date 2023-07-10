package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    @DisplayName("로또 숫자 생성 테스트")
    void createLottoNumberTest(int value) {
        assertDoesNotThrow(() -> new LottoNumber(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("로또 숫자 생성 불가 테스트")
    void createLottoNumberThrowsExceptionTest(int value) {
        assertThrows(IllegalArgumentException.class, () -> {
            new LottoNumber(value);
        });
    }
}
