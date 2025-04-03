package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @ParameterizedTest
    @DisplayName("로또 번호는 1과 45사이에 있어야 한다.")
    @ValueSource(ints = {1, 45})
    void lottoNumberTest(int number) {
        //given
        //when
        LottoNumber lottoNumber = new LottoNumber(number);

        //then
        Assertions.assertThat(lottoNumber.getNumber()).isEqualTo(number);
    }

    @ParameterizedTest
    @DisplayName("로또 번호는 1과 45사이에 없으면 에러를 던진다.")
    @ValueSource(ints = {0, 46})
    void lottoNumberThrowTest(int number) {
        //given
        //when
        //then
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(number))
                .withMessageContaining("로또 번호는 1과 45 사이에 있어야 합니다.");
    }


}