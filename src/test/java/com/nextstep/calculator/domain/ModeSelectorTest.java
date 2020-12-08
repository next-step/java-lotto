package com.nextstep.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ModeSelectorTest {
    @DisplayName("커스텀 모드 여부를 알 수 있다.")
    @Test
    void isCustomTest() {
        String value = "//;\n1;2;3";

        ModeSelector modeSelector = new ModeSelector(value);

        assertThat(modeSelector.isCustom()).isEqualTo(true);
    }
}
