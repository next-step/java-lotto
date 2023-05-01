package lotto.domain;

import lotto.domain.exception.InvalidLottoMatchingCountException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoPrizeTest {
    @ParameterizedTest(name = "번호가 {0}개 동일하면 당첨 금액은 {1}이다.")
    @CsvSource(value = {"3:5000", "4:50000", "5:1500000", "6:2000000000"}, delimiter = ':')
    void 당첨_번호_갯수에_따라_당첨_금액을_알_수_있다(int input, long expected) {
        LottoPrize lottoPrize = LottoPrize.from(input);
        assertThat(lottoPrize.getPrize()).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{0}은 적절한 로또 당첨 갯수가 아니므로 예외가 발생한다.")
    @ValueSource(ints = {2, 0, -2, 9})
    void 일치하는_숫자가_3에서_6_사이가_아니면_예외가_발생한다(int input) {
        assertThatThrownBy(() -> LottoPrize.from(input)).isInstanceOf(InvalidLottoMatchingCountException.class);
    }
}
