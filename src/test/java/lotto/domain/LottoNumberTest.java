package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    public void invalidNumberThrowException(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoNumber.of(number);
        }).withMessage("로또 번호는 1부터 45까지만 가능합니다.");
    }
}
