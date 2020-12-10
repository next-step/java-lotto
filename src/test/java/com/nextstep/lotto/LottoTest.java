package com.nextstep.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {

    @DisplayName("로또 숫자가 6개가 아닐 경우 예외처리")
    @Test
    void lotto() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(Arrays.asList(1,2,3,4,5)));
    }

}
