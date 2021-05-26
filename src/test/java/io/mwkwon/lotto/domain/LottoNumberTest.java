package io.mwkwon.lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    void 로또_번호_문자_생성_static_method_테스트() {
        LottoNumber lottoNumber = LottoNumber.create(7);
        assertThat(lottoNumber).isEqualTo(LottoNumber.create(7));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 로또번호_1에서_45사이의_값이_아닌_다른값이_입력되는_경우_에러_정상_반환_여부_테스트(int number) {
        assertThatThrownBy(() -> LottoNumber.create(number)).isInstanceOf(IllegalArgumentException.class);
    }
}
