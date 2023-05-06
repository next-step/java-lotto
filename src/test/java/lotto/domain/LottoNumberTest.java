package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {

    @Test
    @DisplayName("로또 번호 생성 테스트(객체 동등성,동일성 테스트)")
    void manualProvideLottoNumber() {
        assertThat(LottoNumber.provideLottoNumber(1)).isEqualTo(new LottoNumber(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 4, 5, 6, 7, 43})
    @DisplayName("로또 번호 범위 테스트")
    void autoCreateLottoNumber(int number) {

        LottoNumber lottoNumber = LottoNumber.provideLottoNumber(number);

        assertThat(lottoNumber).isLessThanOrEqualTo(new LottoNumber(45));
    }

    @Test
    @DisplayName("로또 번호 생성 테스트(숫자 범위 1~45)")
    void autoProvideLottoNumber() {
        LottoNumber lottoNumber = LottoNumber.provideLottoNumber();


        assertThat(lottoNumber).isLessThanOrEqualTo(new LottoNumber(45));
    }

    @Test
    @DisplayName("동일한 로또 번호 테스트 ")
    void isSameLottoNumber() {
        LottoNumber lottoNumber = LottoNumber.provideLottoNumber(4);

        assertThat(lottoNumber.isSameLottoNumber(new LottoNumber(4))).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {46, 47, 48})
    @DisplayName("로또 번호 범위(1~45) 를 넘기면 예외를 던진다")
    void overLottoNumber(int number) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.provideLottoNumber(number))
                .withMessage("로또 번호 범위가 아니에요 :(");

    }


}