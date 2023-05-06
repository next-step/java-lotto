package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {

    @Test
    void 숫자_1부터_45까지_생성_성공() {
        assertThatNoException().isThrownBy(() -> new LottoNumber(1));
        assertThatNoException().isThrownBy(() -> new LottoNumber(45));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 숫자1_미만_45_초과_생성시_IllegalArgumentException(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(number));
    }

    @Test
    void 로또_번호_숫자가_같으면_같은_객체로_간주() {
        LottoNumber lottoNumber1 = new LottoNumber(1);
        LottoNumber lottoNumber2 = new LottoNumber(1);
        assertThat(lottoNumber1).isEqualTo(lottoNumber2);
    }
}
