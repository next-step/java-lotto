package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoNumberTest {

    @ParameterizedTest
    @DisplayName("로또의 범위에 넘어서는 숫자를 입력하실 수 없습니다.")
    @ValueSource(ints = {0, 46})
    void lottoNotNegativeNumber(int value) {
        assertThrows(RuntimeException.class, () -> {
            new LottoNumber(value);
        });
    }
}