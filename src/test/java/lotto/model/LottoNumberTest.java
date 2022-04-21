package lotto.model;

import lotto.exception.InvalidLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 23, 45})
    @DisplayName("로또 숫자일 경우 정상적으로 로또 번호를 생성한다")
    void createLottoNumber(int value) {
        //given, when
        LottoNumber lottoNumber = new LottoNumber(value);

        //then
        assertThat(lottoNumber).isEqualTo(new LottoNumber(value));
    }

    @Test
    @DisplayName("로또 숫자가 아니면 예외를 발생한다")
    void throwInvalidLottoNumberException() {
        assertAll(
                () -> assertThatThrownBy(() -> new LottoNumber(0)).isInstanceOf(InvalidLottoNumberException.class),
                () -> assertThatThrownBy(() -> new LottoNumber(46)).isInstanceOf(InvalidLottoNumberException.class)
        );
    }

}