package lotto.domain;

import lotto.exception.NotNumberRangeException;
import lotto.testutil.TestUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinNumbersTest {

    @Test
    @DisplayName("실패 - 당첨 번호의 숫자가 1 ~ 45범위가 아니면 당첨 번호는 생성되지 않는다. ")
    void fail_not_range_win_lotto_number() {
        Assertions.assertThatThrownBy(() -> new LottoWinNumbers(TestUtil.generateLottoNumbers(List.of(0, 2, 3, 4, 5, 46))))
                .isInstanceOf(NotNumberRangeException.class)
                .hasMessage("로또 숫자는 1부터 45까지 입니다.");
    }

    @ParameterizedTest
    @MethodSource("provideLottoNumbersAndMatchCount")
    @DisplayName("성공 - 로또 번호와 당첨 번호를 비교하여 당첨된 숫자의 개수를 반환한다.")
    void success_lotto_number_compare_match_count(List<Integer> lottoNumbers, int bonusBall, LottoRank expectLottoRank) {
        LottoWinNumbers lottoWinNumbers = new LottoWinNumbers(
                TestUtil.generateLottoNumbers(List.of(1, 2, 3, 4, 5, 6))
        );

        LottoRank lottoRank = lottoWinNumbers.matchCount(TestUtil.generateLottoNumbers(lottoNumbers), new BonusBall(bonusBall));
        assertThat(lottoRank).isEqualTo(expectLottoRank);
    }

    private static Stream<Arguments> provideLottoNumbersAndMatchCount() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 7, 8, 9), 10, LottoRank.FIFTH),
                Arguments.of(List.of(1, 2, 3, 4, 8, 9), 10, LottoRank.FOURTH),
                Arguments.of(List.of(1, 2, 3, 4, 5, 9), 10, LottoRank.THIRD),
                Arguments.of(List.of(1, 2, 3, 4, 5, 10), 10, LottoRank.SECOND),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 10, LottoRank.FIRST)
        );
    }

}
