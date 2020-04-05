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
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(number));
    }

    @Test
    public void stringCreate() {
        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber("1"));
    }

    @Test
    public void compareTo() {
        lottoNumber = new LottoNumber(2);
        assertThat(lottoNumber.compareTo(new LottoNumber(2))).isEqualTo(0);
        assertThat(lottoNumber.compareTo(new LottoNumber(1))).isEqualTo(1);
        assertThat(lottoNumber.compareTo(new LottoNumber(3))).isEqualTo(-1);
    }
}
