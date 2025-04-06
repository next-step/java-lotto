package com.nextstep.camp.lotto.domain.vo;

import com.nextstep.camp.lotto.domain.exception.LottoCountCannotBeNegativeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoCountTest {

    @ParameterizedTest(name = "input={0}")
    @ValueSource(ints = {0, 1, 5, 100})
    @DisplayName("0 이상 정수로 LottoCount를 생성할 수 있다")
    void validLottoCountCreation(int input) {
        LottoCount count = LottoCount.of(input);
        assertEquals(input, count.getCount());
    }

    @ParameterizedTest(name = "input={0}")
    @ValueSource(ints = {-1, -10, -999})
    @DisplayName("음수로 LottoCount를 생성하면 예외가 발생한다")
    void invalidLottoCountCreation(int input) {
        assertThrows(LottoCountCannotBeNegativeException.class, () -> LottoCount.of(input));
    }

    @Test
    @DisplayName("LottoCount.minus로 정상적으로 값을 뺄 수 있다")
    void minusShouldSubtractProperly() {
        LottoCount base = LottoCount.of(5);
        LottoCount subtract = LottoCount.of(2);

        LottoCount result = base.minus(subtract);
        assertEquals(3, result.getCount());
    }

    @Test
    @DisplayName("LottoCount.minus로 음수가 되면 예외 발생")
    void minusShouldThrowIfNegative() {
        LottoCount base = LottoCount.of(2);
        LottoCount subtract = LottoCount.of(5);

        assertThrows(LottoCountCannotBeNegativeException.class, () -> base.minus(subtract));
    }
}
