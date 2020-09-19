package lotto2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {

    @DisplayName("1-45 사이 숫자 저장")
    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void newInstance(int number) {
        //when
        LottoNumber lottoNumber = new LottoNumber(number);

        //then
        assertThat(lottoNumber).isNotNull();
    }

    @DisplayName("1-45 사이 숫자 저장")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void newInstanceWithWrongNumber(int number) {
        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(number))
        .withMessage("잘못된 로또 번호 입니다.");
    }
}