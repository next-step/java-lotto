package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {
    private LottoNumber lottoNumber;

    @ParameterizedTest
    @ValueSource(ints = {1, 23, 45})
    public void create(int number) {
        lottoNumber = new LottoNumber(number);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    public void doNotCreate(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> lottoNumber = new LottoNumber(number));
    }

    @Test
    public void stringCreate() {
        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber("1"));
    }
}
