package step4.lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.lotto.domain.LottoNumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {


    @Test
    void init() {
        LottoNumber lottoNumber = new LottoNumber(3);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(3));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1,0,46,75})
    void 로또번호_예외값_입력(int number) {
        assertThatThrownBy(() -> {
            LottoNumber lottoNumber = new LottoNumber(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
