package lotto;

import lotto.domain.LottoNumberValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class LottoNumberValidatorTest {
    @Test
    void 로또번호가_정해진_범위내의_숫자가_아니면_예외_발생() {
        // given
        Set<Integer> lottoNumbers = Set.of(46, 1, 2, 3, 4, 5);

        // when, then
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LottoNumberValidator.validateLottoNumbers(lottoNumbers))
                .withMessageMatching("로또번호는 \\d+~\\d+ 사이의 숫자만 가능합니다");
    }
}
