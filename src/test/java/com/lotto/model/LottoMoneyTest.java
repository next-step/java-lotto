package com.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoMoneyTest {
    @DisplayName("Lotto 가격 보다 낮은 가격 입력 시 테스트")
    @Test
    public void underMinimumValueTest() {
        //then
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoMoney(999));
    }
}
