package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {


    @ParameterizedTest
    @ValueSource(ints = {1,10,15,30,45})
    @DisplayName("로또 번호가 정상적으로 생성되는것을 확인")
    void get_normalNumber_equalTo(int number) {
        LottoNumber lottoNumber = LottoNumber.get(number);
        assertThat(lottoNumber).isEqualTo(LottoNumber.get(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {50,46,-1,0})
    @DisplayName("로또 번호가 아닌 경우 예외 발생")
    void get_overNumber_exceptionThrown(int number) {
        assertThatThrownBy(() -> {
            LottoNumber.get(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
