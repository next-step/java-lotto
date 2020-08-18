package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 50})
    @DisplayName("로또 번호 범위 에러 테스트")
    void lotto_number_range_test(int number) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            LottoNumber.generate(number);
        });
    }
}
