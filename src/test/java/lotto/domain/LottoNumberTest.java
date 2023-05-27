package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @ParameterizedTest(name = "로또 번호 범위가 안 맞을 경우 검사")
    @ValueSource(ints = {0, 46})
    void test1(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(number);
        });
    }
}
