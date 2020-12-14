package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    @DisplayName("유효 범위 내의 로또 번호 생성 테스트")
    void valid_lotto_number_test(int number) {
        // given
        LottoNumber lottoNumber = LottoNumber.ofNumber(number);

        // when & then
        assertThat(lottoNumber).isEqualTo(LottoNumber.ofNumber(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 50})
    @DisplayName("유효 범위 밖의 로또 번호 테스트")
    void invalid_lotto_number_test(int number) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            LottoNumber lottoNumber = LottoNumber.ofNumber(number);
        }).withMessageMatching("로또 번호는 1에서 45사이 숫자 입니다.");
    }

}
