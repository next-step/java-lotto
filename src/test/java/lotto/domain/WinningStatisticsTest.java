package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WinningStatisticsTest {

    private Lottos lottos;
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        /*
        6개 일치
         */
        List<LottoNumber> lottoNumbers1 = Arrays.asList(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6)
        );
        /*
        6개 일치
         */
        List<LottoNumber> lottoNumbers2 = Arrays.asList(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6)
        );
        /*
        5개 일치
         */
        List<LottoNumber> lottoNumbers3 = Arrays.asList(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(7)
        );
        /*
        4개 일치
         */
        List<LottoNumber> lottoNumbers4 = Arrays.asList(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(7),
                LottoNumber.from(8)
        );
        /*
        4개 일치
         */
        List<LottoNumber> lottoNumbers5 = Arrays.asList(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(8),
                LottoNumber.from(9)
        );
        /*
        3개 일치
         */
        List<LottoNumber> lottoNumbers6 = Arrays.asList(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(7),
                LottoNumber.from(8),
                LottoNumber.from(9)
        );
        /*
        2개 일치
         */
        List<LottoNumber> lottoNumbers7 = Arrays.asList(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(7),
                LottoNumber.from(8),
                LottoNumber.from(9),
                LottoNumber.from(10)
        );
        /*
        1개 일치
         */
        List<LottoNumber> lottoNumbers8 = Arrays.asList(
                LottoNumber.from(1),
                LottoNumber.from(7),
                LottoNumber.from(8),
                LottoNumber.from(9),
                LottoNumber.from(10),
                LottoNumber.from(11)
        );
        /*
        0개 일치
         */
        List<LottoNumber> lottoNumbers9 = Arrays.asList(
                LottoNumber.from(11),
                LottoNumber.from(12),
                LottoNumber.from(13),
                LottoNumber.from(14),
                LottoNumber.from(15),
                LottoNumber.from(16)
        );

        List<Lotto> lottoList = Arrays.asList(
                Lotto.from(lottoNumbers1),
                Lotto.from(lottoNumbers2),
                Lotto.from(lottoNumbers3),
                Lotto.from(lottoNumbers4),
                Lotto.from(lottoNumbers5),
                Lotto.from(lottoNumbers6),
                Lotto.from(lottoNumbers7),
                Lotto.from(lottoNumbers8),
                Lotto.from(lottoNumbers9)
        );

        this.lottos = Lottos.from(lottoList);
        this.winningLotto = WinningLotto.from(new String[] {"1", "2", "3", "4", "5", "6"});
    }

    @ParameterizedTest
    @DisplayName("로또 들의 당첨 결과를 담은 Map 을 생성한다.")
    @MethodSource
    void createWinningStatistics(Rank rank, int expectedCount) {
        WinningStatistics statistics = WinningStatistics.from(lottos, winningLotto);

        int rankCount = statistics.rankCount(rank);

        assertThat(rankCount).isEqualTo(expectedCount);
    }

    static Stream<Arguments> createWinningStatistics() {
        return Stream.of(
                Arguments.of(
                        Rank.FIRST, 2
                ),
                Arguments.of(
                        Rank.SECOND, 1
                ),
                Arguments.of(
                        Rank.THIRD, 2
                ),
                Arguments.of(
                        Rank.FOURTH, 1
                ),
                Arguments.of(
                        Rank.FIFTH, 1
                ),
                Arguments.of(
                        Rank.SIXTH, 1
                ),
                Arguments.of(
                        Rank.NOTHING, 1
                )
        );
    }
}