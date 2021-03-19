package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @DisplayName("로또 넘버는 1이상 45이하 여야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void lottoNumberRange(int number) {
        assertThatThrownBy(() -> {
            LottoNumber.of(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 넘버가 같으면 같은 로또이다.")
    @Test
    void lottoEquals() {
        LottoNumber lottoNumber = LottoNumber.of(1);
        assertThat(lottoNumber).isEqualTo(LottoNumber.of(1));
    }

    @DisplayName("로또 넘버를 생성한다.")
    void lottoNumber() {
        LottoNumber stringToLottoNumber = LottoNumber.of("5");
        LottoNumber intToLottoNumber = LottoNumber.of(5);
        assertThat(stringToLottoNumber).isEqualTo(intToLottoNumber);
    }

}