package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 15, 40, 45})
    @DisplayName("1이상 45이하의 범위내 값으로 LottoNumber를 생성하면, LottoNumber는 정상적으로 생성된다.")
    void testGenerateLottoNumber(final int num) {
        //given
        final LottoNumber lottoNumber = new LottoNumber(num);

        //when
        final int number = lottoNumber.number();

        //then
        assertThat(number).isEqualTo(num);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 47, 90})
    @DisplayName("LottoNumber를 생성할 때, 1이상 45이하의 수를 가지고 있지 않으면 IllegalArgumentException 예외가 발생한다.")
    void testConstructorThrowsIllegalArgumentExceptionIfNumValueIsNotValid(final int num) {
        //given, when, then
        assertThatThrownBy(() -> new LottoNumber(num))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("lotto num value must be 1 ~ 45");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 15, 40, 45})
    @DisplayName("LottoNumber는 number값이 같으면, 같은 객체로 취급한다.")
    void testEqualsReturnsTrueIfNumberIsTheSame(final int num) {
        //given
        final LottoNumber lottoNumber1 = new LottoNumber(num);
        final LottoNumber lottoNumber2 = new LottoNumber(num);

        //when
        final boolean equals = lottoNumber1.equals(lottoNumber2);

        //then
        assertThat(equals).isTrue();
    }
}
