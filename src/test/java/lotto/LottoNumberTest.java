package lotto;

import lotto.domain.LottoNumber;
import lotto.exception.CustomIllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @DisplayName("범위를 벗어나는 값을 입력하면 Exception을 던진다")
    @ParameterizedTest(name = "{displayName} ==> input : {0}")
    @ValueSource(ints = {-1, 0, 46})
    void throw_exception_when_out_of_range(int input) {
        //Given+When+Then
        assertThatThrownBy(() -> LottoNumber.of(input))
                .isInstanceOf(CustomIllegalArgumentException.class);
    }

    @DisplayName("int number변수의 값이 같으면 동일한 객체로 인식한다")
    @Test
    void equals_true_when_same_number() {
        //Given
        LottoNumber lottoNumber1 = LottoNumber.of(3);
        LottoNumber lottoNumber2 = LottoNumber.of(3);

        //When + Then
        assertThat(lottoNumber1.equals(lottoNumber2)).isTrue();
    }

    @DisplayName("int number변수의 값이 다르면 다른 객체로 인식한다")
    @Test
    void equals_false_when_different_number() {
        //Given
        LottoNumber lottoNumber1 = LottoNumber.of(3);
        LottoNumber lottoNumber2 = LottoNumber.of(45);

        //When + Then
        assertThat(lottoNumber1.equals(lottoNumber2)).isFalse();
    }

    @DisplayName("로또 번호 생성")
    @Test
    void create(){
        LottoNumber lottoNumber = LottoNumber.of(1);
        assertThat(LottoNumber.of(1)).isEqualTo(lottoNumber);
    }

    @DisplayName("동일 로또 번호 주소값 비교")
    @Test
    void check_static(){
        assertThat(LottoNumber.of(1)==LottoNumber.of(1)).isTrue();
    }
}
