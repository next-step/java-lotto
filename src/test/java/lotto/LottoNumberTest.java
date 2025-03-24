package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    @DisplayName("1~45 사이의 숫자면 로또 번호가 생성된다.")
    public void validLottoNumber(){
        assertThat(new LottoNumber(2)).isEqualTo(new LottoNumber(2));
    }

    @Test
    @DisplayName("1~45 사이의 숫자가 아니면 예외가 발생한다.")
    public void invalidLottoNumber(){
        assertThatThrownBy(() -> new LottoNumber(50))
                .isInstanceOf(IllegalArgumentException.class);
    }
}