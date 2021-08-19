package lotto.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WinningStatisticsTest {

    private Lottos lottos;
    private WinningLotto winningLotto;

    @BeforeEach
    void setWinningLotto() {
        List<LottoNumber> lottoNumbers1 = Arrays.asList(new LottoNumber(1),new LottoNumber(2),new LottoNumber(3),new LottoNumber(4),new LottoNumber(5),new LottoNumber(6));
        List<LottoNumber> lottoNumbers2 = Arrays.asList(new LottoNumber(1),new LottoNumber(2),new LottoNumber(3),new LottoNumber(4),new LottoNumber(5),new LottoNumber(10));
        List<LottoNumber> lottoNumbers3 = Arrays.asList(new LottoNumber(1),new LottoNumber(2),new LottoNumber(3),new LottoNumber(4),new LottoNumber(5),new LottoNumber(12));
        List<LottoNumber> lottoNumbers4 = Arrays.asList(new LottoNumber(10),new LottoNumber(12),new LottoNumber(13),new LottoNumber(14),new LottoNumber(15),new LottoNumber(16));

        lottos = new Lottos(
                Arrays.asList(
                        new Lotto(lottoNumbers1)
                        ,new Lotto(lottoNumbers1)
                        ,new Lotto(lottoNumbers2)
                        ,new Lotto(lottoNumbers2)
                        ,new Lotto(lottoNumbers3)
                        ,new Lotto(lottoNumbers4)
                        ,new Lotto(lottoNumbers4)));

        winningLotto = new WinningLotto(new Lotto(lottoNumbers1), new LottoNumber(10));
    }

    static Stream<Arguments> winningStatisticsSource() {
        return Stream.of(
                arguments(Rank.FIRST, 2L),
                arguments(Rank.SECOND, 2L),
                arguments(Rank.THIRD, 1L),
                arguments(Rank.NO_RANK, 2L)
        );
    }

    @ParameterizedTest
    @DisplayName("랭크 개수 구하기")
    @MethodSource("winningStatisticsSource")
    void rankCount(Rank rank, Long expected) {
        WinningStatistics winningStatistics = new WinningStatistics(lottos, winningLotto);
        Long actual = winningStatistics.getRankCount(rank);

        assertThat(actual).isEqualTo(expected);
    }

}