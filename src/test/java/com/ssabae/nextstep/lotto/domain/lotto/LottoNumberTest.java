package com.ssabae.nextstep.lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-18
 */
@DisplayName("LottoNumber Test Class")
class LottoNumberTest {

    @ParameterizedTest(name = "{displayName}[{index}] - \"{arguments}\"")
    @DisplayName("LottoNumber 생성 Test")
    @ValueSource(ints = {1, 45})
    void lottoNumberCreateTest(int value) {
        LottoNumber lottoNumber_01 = LottoNumber.of(value);
        assertThat(lottoNumber_01).isEqualTo(LottoNumber.of(value));
    }

    @ParameterizedTest(name = "{displayName}[{index}] - \"{arguments}\"")
    @DisplayName("LottoNumber 생성시 정합성 Test")
    @ValueSource(ints = {0, -1, 46})
    void shouldBeThrowIllegalArgumentException(int value) {
        assertThatThrownBy(() -> LottoNumber.of(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
