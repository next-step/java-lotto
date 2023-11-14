package lotto.domain;

import lotto.strategy.TestLottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinNumbersTest {

    @ParameterizedTest
    @MethodSource("provideLottoNumbersAndMatchCount")
    @DisplayName("성공 - 로또 번호와 당첨 번호를 비교하여 당첨된 숫자의 개수를 반환한다.")
    void success_lotto_number_compare_match_count(List<Integer> lottoNumbers, long matchCount) {
        LottoWinNumbers lottoWinNumbers = new LottoWinNumbers(
                List.of(1,2,3,4,5,6)
        );

        assertThat(lottoWinNumbers.matchCount(lottoNumbers)).isEqualTo(matchCount);
    }

    private static Stream<Arguments> provideLottoNumbersAndMatchCount() {
        return Stream.of(
                Arguments.of(List.of(1,2,3,7,8,9), 3),
                Arguments.of(List.of(1,2,3,4,8,9), 4),
                Arguments.of(List.of(1,2,3,4,5,9), 5),
                Arguments.of(List.of(1,2,3,4,5,6), 6)
        );
    }

}
