package lotto.domain;

import lotto.domain.exception.InvalidLottoMatchingCountException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoPrizeTest {
    @ParameterizedTest(name = "번호가 {0}개 동일하고 보너스 당첨 여부가 {1}이면 당첨 금액은 {2}이다.")
    @CsvSource(value = {
            "0:false:0",
            "0:true:0",
            "1:false:0",
            "1:true:0",
            "2:false:0",
            "2:true:0",
            "3:false:5_000",
            "3:true:5_000",
            "4:false:50_000",
            "4:true:50_000",
            "5:false:1_500_000",
            "5:true:30_000_000",
            "6:false:2_000_000_000",
            "6:true:2_000_000_000"
    }, delimiter = ':')
    void 당첨_번호_갯수와_보너스_번호_일치_여부에_따라_당첨_금액을_알_수_있다(int input, boolean matchBonus, long prize) {
        LottoPrize lottoPrize = LottoPrize.from(input, matchBonus);
        assertThat(lottoPrize.getPrize()).isEqualTo(prize);
    }

    @ParameterizedTest(name = "{0}등은 숫자가 {1}개 같다.")
    @MethodSource("getInputFor_등수에_따른_일치하는_번호_갯수를_알_수_있다")
    void 등수에_따른_일치하는_번호_갯수를_알_수_있다(LottoPrize lottoPrize, int match) {
        assertThat(lottoPrize.getMatchingCount()).isEqualTo(match);
    }

    @Test
    void 당첨_횟수에_따른_총_상금을_알_수_있다() {
        assertThat(LottoPrize.FOURTH.getTotalPrize(3)).isEqualTo(150_000);
    }

    @ParameterizedTest(name = "{0}은 적절한 로또 당첨 갯수가 아니므로 예외가 발생한다.")
    @ValueSource(ints = {-2, 9})
    void 일치하는_숫자가_0에서_6_사이가_아니면_예외가_발생한다(int input) {
        assertThatThrownBy(() -> LottoPrize.from(input, false)).isInstanceOf(InvalidLottoMatchingCountException.class);
    }

    private static Stream<Arguments> getInputFor_등수에_따른_일치하는_번호_갯수를_알_수_있다() {
        return Stream.of(
                Arguments.arguments(LottoPrize.FIRST, 6),
                Arguments.arguments(LottoPrize.SECOND, 5),
                Arguments.arguments(LottoPrize.THIRD, 5),
                Arguments.arguments(LottoPrize.FOURTH, 4),
                Arguments.arguments(LottoPrize.FIFTH, 3),
                Arguments.arguments(LottoPrize.NONE, 0)
        );
    }
}
