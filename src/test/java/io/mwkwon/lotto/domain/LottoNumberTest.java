package io.mwkwon.lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    void 로또_넘버_정상_생성_여부_테스트() {
        LottoNumber lottoNumber = new LottoNumber(1);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 로또번호_1에서_45사이의_값이_아닌_다른값이_입력되는_경우_에러_정상_반환_여부_테스트(int number) {
        assertThatThrownBy(() -> new LottoNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자열_값을_이용하여_로또_넘버_정상_생성_여부_테스트() {
        LottoNumber lottoNumber = new LottoNumber("7");
        assertThat(lottoNumber).isEqualTo(new LottoNumber(7));
    }

    @ParameterizedTest
    @ValueSource(strings = {"100", "46", "0", "-1"})
    void 로또_1에서_45사이의_문자열이_아닌_다른값이_입력되는_경우_에러_정상_반환_여부_테스트(String numberString) {
        assertThatThrownBy(() ->new LottoNumber(numberString)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"일", "이", "십구", "1 7"})
    void 숫자로된_문자열이_아닐_경우_에러_정상_발생_테스트(String numberString) {
        assertThatThrownBy(() ->new LottoNumber(numberString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력 가능 합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {" 7:7", "7 :7"}, delimiter = ':')
    void 공백이_포함된_숫자_문자열_입력_시_정상_생성_테스트(String numberString, int excepted) {
        LottoNumber lottoNumber = new LottoNumber(numberString);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(excepted));
    }

    @Test
    void 로또_번호_문자_생성_static_method_테스트() {
        LottoNumber lottoNumber = LottoNumber.create("7");
        assertThat(lottoNumber).isEqualTo(new LottoNumber(7));
    }
}
