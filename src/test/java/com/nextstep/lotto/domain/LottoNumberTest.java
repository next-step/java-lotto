package com.nextstep.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @DisplayName("범위 벗어난 값 예외처리 확인")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void outOfRange(int source) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(source));
    }
}
