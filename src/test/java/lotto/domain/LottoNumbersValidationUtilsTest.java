package lotto.domain;

import lotto.utils.LottoNumbersValidationUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LottoNumbersValidationUtilsTest {

    @Test
    @DisplayName("[요구사항 1] 로또 번호 개수가 6개가 아닐 경우 IllegalArgumentException throw")
    void 요구사항_1() {
        // given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        // then
        Assertions.assertThatThrownBy(() -> LottoNumbersValidationUtils.validateIfLottoNumbersSizeIsSix(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 6개의 숫자로 구성되어야 합니다.");
    }

    @Test
    @DisplayName("[요구사항 2] 로또 번호가 중복될 시 IllegalArgumentException throw")
    void 요구사항_2() {
        // given
        List<Integer> lottoNumbers = Arrays.asList(1, 1, 2, 2, 5, 6);

        // then
        Assertions.assertThatThrownBy(() -> LottoNumbersValidationUtils.validateLottoNumbers(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호들은 서로 다른 숫자여야만 한다.");
    }
}
