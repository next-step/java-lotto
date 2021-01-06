package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    void create_test() throws Exception {
        //Given
        LottoNumber lottoNumber = new LottoNumber(1);
        //When
        Integer number = lottoNumber.getNumber();
        //Then
        assertThat(number).isEqualTo(1);
    }

    @Test
    void validate_number_test() throws Exception {
        //Given and When and Then
        assertThatThrownBy(() -> {
            LottoNumber lottoNumber = new LottoNumber(100);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
