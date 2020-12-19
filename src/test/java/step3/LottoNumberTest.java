package step3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.LottoNumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    public void invalid_로또번호_유효범위_내(int number) {
        assertThat(LottoNumber.of(number).getNumber()).isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    public void invalid_로또번호_유효범위_밖(int number) {
        assertThatThrownBy(() -> {
            LottoNumber.of(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
