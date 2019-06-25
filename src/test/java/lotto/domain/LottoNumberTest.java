package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

/**
 * Created by wyparks2@gmail.com on 2019-06-25
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class LottoNumberTest {
    @Test
    void 로또번호_가져오기() {
        LottoNumber lottoNumber = new LottoNumber(1);

        assertThat(lottoNumber.getNumber()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void 로또번호_1부터_45까지_생성가능(int number) {
        LottoNumber lottoNumber = new LottoNumber(number);
        assertThat(lottoNumber.getNumber()).isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 로또번호_1이하_45이상_오류발생(int number) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->
                        new LottoNumber(number)
                );
    }

}
