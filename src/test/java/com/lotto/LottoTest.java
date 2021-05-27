package com.lotto;

import com.lotto.domain.Lotto;
import com.lotto.domain.WinningLotto;
import com.lotto.exception.IllegalLottoCountException;
import com.lotto.exception.LottoNumberFormatException;
import com.lotto.exception.LottoNumberOutOfBoundsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;

public class LottoTest {
    @DisplayName("로또생성: 입력개수가 6개가 아니면 예외 발생")
    @Test
    void 로또생성_입력개수_예외() {
        assertThatThrownBy(() -> Lotto.createLotto("1,2,3,4,5"))
                .isInstanceOf(IllegalLottoCountException.class);
        assertThatThrownBy(() -> Lotto.createLotto("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalLottoCountException.class);
    }

    @DisplayName("로또생성: 로또번호 포맷 예외")
    @ParameterizedTest
    @ValueSource(strings = {"asd", ""})
    void createLottoWinningNumbers_잘못된입력데이터_예외(String input) {
        assertThatThrownBy(() -> Lotto.createLotto(input))
                .isInstanceOf(LottoNumberFormatException.class);
    }

    @DisplayName("로또생성: 로또번호 범위 예외")
    @Test
    void createLottoWinningNumbers_잘못된입력데이터_음수_예외() {
        assertThatThrownBy(() -> Lotto.createLotto("-1,-2,-3,-4,-5,-6"))
                .isInstanceOf(LottoNumberOutOfBoundsException.class);
    }
}
