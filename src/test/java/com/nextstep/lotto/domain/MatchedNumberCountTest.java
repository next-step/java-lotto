package com.nextstep.lotto.domain;

import com.nextstep.lotto.domain.exceptions.InvalidMatchedNumberCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MatchedNumberCountTest {
    @DisplayName("잘못된 숫자로 생성 시도 시 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = { -1, 7 })
    void createFailTest(int invalidValue) {
        assertThatThrownBy(() -> new MatchedNumberCount(invalidValue))
                .isInstanceOf(InvalidMatchedNumberCountException.class);
    }
}