package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("로또번호가 1 - 45 사이에서 생성되는지 확인")
    public void new_lotto_number_failed(int input) {
        assertThrows(IllegalArgumentException.class, () -> {
            new LottoNumber(input);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    @DisplayName("로또번호가 1 - 45 사이에서 생성되는지 확인")
    public void new_lotto_number_succeed(int input) {
        LottoNumber lottoNumber = new LottoNumber(input);
        assertThat(input).isEqualTo(lottoNumber.toInt());
    }
}
