package com.nextstep.lotto.view;

import com.nextstep.lotto.view.exceptions.InvalidNumberOfStaticLottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberOfStaticLottoTest {
    @DisplayName("음수로 객체 생성 시도 시 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2})
    void createFailTest(int negativeValue) {
        assertThatThrownBy(() -> new NumberOfStaticLotto(negativeValue))
                .isInstanceOf(InvalidNumberOfStaticLottoException.class);
    }
}