package com.nextstep.lotto.view;

import com.nextstep.lotto.domain.exceptions.InvalidLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberInputViewTest {
    @DisplayName("보너스 번호로 사용할 수 없는 값을 파싱 시도 시 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, 47, -1})
    void parseFailTest(int invalidValue) {
        BonusNumberInputView bonusNumberInputView = new BonusNumberInputView(invalidValue);

        assertThatThrownBy(() -> bonusNumberInputView.parseToBonusNumber())
                .isInstanceOf(InvalidLottoNumberException.class);
    }
}