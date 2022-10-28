package lotto.backend.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @ParameterizedTest(name = "[{index}] 45 MAX 초과 {0} = error")
    @ValueSource(ints = {46, 50, 52})
    void over_max_number(int num) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> LottoNumber.of(num));
    }
}
