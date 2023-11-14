package lotto.domain;

import lotto.strategy.TestLottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @ParameterizedTest
    @MethodSource("provideWinLottoNumbersAndWinCount")
    @DisplayName("성공 - 로또 번호와 당첨 번호를 비교하여 당첨 통계를 낸다.")
    void success_lotto_winning_count(List<Integer> lottoNumbers, List<Integer> winLottoNumbers, long matchCount, long winCount) {
        Lottos lottos = new Lottos(Map.ofEntries(
                entry(1, List.of(new Lotto(new LottoNumbers(new TestLottoGenerator(lottoNumbers)))))
        ));

        Map<Long, Long> lottoStat = lottos.winCounts(winLottoNumbers);

        assertThat(lottoStat).hasSize(4)
                .contains(
                        entry(matchCount, winCount)
                );
    }

    private static Stream<Arguments> provideWinLottoNumbersAndWinCount() {
        return Stream.of(
                Arguments.of(List.of(3, 5, 11, 1, 2, 4), List.of(3, 5, 11, 20, 21, 22), 3L, 1L),
                Arguments.of(List.of(7, 11, 16, 35, 2, 4), List.of(7, 11, 16, 35, 1, 3), 4L, 1L),
                Arguments.of(List.of(1, 8, 11, 31, 41, 44), List.of(1, 8, 11, 31, 41, 43), 5L, 1L),
                Arguments.of(List.of(13, 14, 16, 38, 42, 45), List.of(13, 14, 16, 38, 42, 45), 6L, 1L)
        );
    }

}