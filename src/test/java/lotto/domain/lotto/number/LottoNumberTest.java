package lotto.domain.lotto.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoNumberTest {
    @DisplayName("입력 금액이 최저금액인 천원보다 크면 Money객체를 생성한다")
    @Test
    public void should_make_object_over_input_value_more_than_lowest_amount() throws Exception {
        //arrange
        LottoNumber lottoNumber = LottoNumber.of(23);

        //act, assert
        assertThat(lottoNumber).isEqualTo(LottoNumber.of(23));
    }

    @DisplayName("1보다 작거나 45보다 크면 IllegalArgumentException이 발생한다")
    @ValueSource(ints = {0, 46})
    @ParameterizedTest
    public void should_throw_exception_input_value_under_than_lowest_amount(int number) throws Exception {
        //arrange, act, assert
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(number));
    }

    @DisplayName("실제값의 문자형태로 변경하여 리턴한다")
    @Test
    public void should_return_string_value() throws Exception {
        //arrange
        LottoNumber lottoNumber = LottoNumber.of(23);

        //act, assert
        assertThat(lottoNumber.getNumberString()).isEqualTo("23");
    }

    @DisplayName("실제값을 리턴한다")
    @Test
    public void should_return_value() throws Exception {
        //arrange
        LottoNumber lottoNumber = LottoNumber.of(23);

        //act, assert
        assertThat(lottoNumber.getNumber()).isEqualTo(23);
    }
}