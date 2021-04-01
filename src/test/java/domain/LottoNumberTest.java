package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import exception.ExceedNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @DisplayName("로또 번호 체크")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,
    26,27,28,45})
    void successNumber(int number){
        LottoNumber lottoNumber = new LottoNumber(number);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(number));
    }

    @DisplayName("로또 번호 초과 시 에러")
    @ParameterizedTest
    @ValueSource(ints = {-1,46,47,48})
    void validateExceedNumber(int number){
        assertThatThrownBy( () ->
            new LottoNumber(number)
        ).isInstanceOf(ExceedNumberException.class);
    }

}
