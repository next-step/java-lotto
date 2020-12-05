package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 45, 46})
    @DisplayName("로또번호가 1 - 45 사이에서 생성되는지 확인")
    public void new_lotto_number(int input) {
        assertThrows(IllegalArgumentException.class, () -> {
            new LottoNumber(input);
        });
    }
}
