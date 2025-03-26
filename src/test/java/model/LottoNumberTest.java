package model;

import model.lotto.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    @DisplayName("1~45 사이의 숫자면 로또 번호가 생성된다.")
    public void validLottoNumber(int number){
        assertThat(new LottoNumber(number)).isEqualTo(new LottoNumber(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0 ,46})
    @DisplayName("1~45 사이의 숫자가 아니면 예외가 발생한다.")
    public void invalidLottoNumber(int number){
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}