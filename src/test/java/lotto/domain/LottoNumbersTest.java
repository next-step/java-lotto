package lotto.domain;

import lotto.exception.NotNumberRangeException;
import lotto.strategy.TestLottoGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {

    @Test
    @ValueSource(ints = {0, 46})
    @DisplayName("실패 - 로또의 숫자가 1 ~ 45범위가 아니면 로또번호는 생성되지 않는다. ")
    void fail_not_range_lotto_number() {
        TestLottoGenerator testLottoGenerator = new TestLottoGenerator(List.of(0, 2, 3, 4, 5, 46));

        Assertions.assertThatThrownBy(() -> new LottoNumbers(testLottoGenerator))
                .isInstanceOf(NotNumberRangeException.class)
                .hasMessage("로또 숫자는 1부터 45까지 입니다.");
    }

    @ParameterizedTest
    @MethodSource("provideWinLottoNumbersAndWinCount")
    @DisplayName("성공 - 로또 번호와 당첨 번호를 비교하여 당첨 번호와 일치하는 개수를 반환한다.")
    void success_lotto_match_count(List<Integer> inputLottoNumbers, List<Integer> winLottoNumbers, long expectCount) {
        LottoNumbers lottoNumbers = new LottoNumbers(new TestLottoGenerator(inputLottoNumbers));

        long matchCount = lottoNumbers.matchCount(winLottoNumbers);

        assertThat(matchCount).isEqualTo(expectCount);
    }

    private static Stream<Arguments> provideWinLottoNumbersAndWinCount() {
        return Stream.of(
                Arguments.of(List.of(13, 14, 16, 38, 42, 45), List.of(13, 14, 16, 37, 41, 44), 3L),
                Arguments.of(List.of(13, 14, 16, 38, 42, 45), List.of(13, 14, 16, 38, 41, 44), 4L),
                Arguments.of(List.of(13, 14, 16, 38, 42, 45), List.of(13, 14, 16, 38, 42, 44), 5L),
                Arguments.of(List.of(13, 14, 16, 38, 42, 45), List.of(13, 14, 16, 38, 42, 45), 6L)
        );
    }

}
