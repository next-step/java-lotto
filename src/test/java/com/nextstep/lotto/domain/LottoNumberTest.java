package com.nextstep.lotto.domain;

import com.nextstep.lotto.domain.exceptions.InvalidLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {
    @DisplayName("숫자를 인수로 받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        int value = 3;

        assertThat(new LottoNumber(value)).isEqualTo(new LottoNumber(value));
    }

    @DisplayName("1 ~ 45 범위를 벗어난 숫자로 객체를 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, 46})
    void createFailTest(int invalidValue) {
        assertThatThrownBy(() -> new LottoNumber(invalidValue)).isInstanceOf(InvalidLottoNumberException.class);
    }
}
