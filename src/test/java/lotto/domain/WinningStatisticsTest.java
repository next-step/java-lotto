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
        6개 일치 - 1등
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
        6개 일치 - 1등
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
        5개 일치 - 2등
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
        5개 일치 - 3등
         */
        List<LottoNumber> lottoNumbers4 = Arrays.asList(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(8)
        );
        /*
        4개 일치 - 4등
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
        3개 일치 - 5등
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
        2개 일치 - NOTHING
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
        1개 일치 - NOTHING
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
        0개 일치 - NOTHING
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
        this.winningLotto = WinningLotto.from(new String[] {"1", "2", "3", "4", "5", "6"}, LottoNumber.from(7));
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
                        Rank.THIRD, 1
                ),
                Arguments.of(
                        Rank.FOURTH, 1
                ),
                Arguments.of(
                        Rank.FIFTH, 1
                ),
                Arguments.of(
                        Rank.NOTHING, 3
                )
        );
    }

    @ParameterizedTest
    @DisplayName("수익률을 계산 한다")
    @MethodSource
    void calcYeild(WinningStatistics statistics, double expected) {
        double yeild = statistics.calcYeiild();

        assertThat(yeild).isEqualTo(expected);
    }

    static Stream<Arguments> calcYeild() {
        List<Lotto> lottoList = Arrays.asList(
                Lotto.from(
                    Arrays.asList(
                        LottoNumber.from(1),
                        LottoNumber.from(2),
                        LottoNumber.from(3),
                        LottoNumber.from(4),
                        LottoNumber.from(5),
                        LottoNumber.from(6)
                    )
                ),
                Lotto.from(
                        Arrays.asList(
                                LottoNumber.from(7),
                                LottoNumber.from(8),
                                LottoNumber.from(9),
                                LottoNumber.from(10),
                                LottoNumber.from(11),
                                LottoNumber.from(12)
                        )
                ),
                Lotto.from(
                        Arrays.asList(
                                LottoNumber.from(13),
                                LottoNumber.from(14),
                                LottoNumber.from(15),
                                LottoNumber.from(16),
                                LottoNumber.from(17),
                                LottoNumber.from(18)
                        )
                )
        );

        Lottos lottos = Lottos.from(lottoList);

        return Stream.of(
                Arguments.of(
                        //3개 로또 중 1등 1개
                    WinningStatistics.from(lottos, WinningLotto.from(new String[] {"1", "2", "3", "4", "5", "6"}, LottoNumber.from(7))),
                        Math.round(2_000_000_000 / (double) 3000)
                ),
                Arguments.of(
                        //3개 로또 중 2등 1개
                    WinningStatistics.from(lottos, WinningLotto.from(new String[] {"1", "2", "3", "4", "5", "8"}, LottoNumber.from(6))),
                        Math.round(30_000_000 / (double) 3000)
                ),
                Arguments.of(
                        //3개 로또 중 3등 1개
                    WinningStatistics.from(lottos, WinningLotto.from(new String[] {"1", "2", "3", "4", "5", "16"}, LottoNumber.from(17))),
                        Math.round(1_500_000 / (double) 3000)
                ),
                Arguments.of(
                        //3개 로또 중 4등 1개
                    WinningStatistics.from(lottos, WinningLotto.from(new String[] {"1", "2", "3", "4", "15", "16"}, LottoNumber.from(17))),
                        Math.round(50_000 / (double) 3000)
                ),
                Arguments.of(
                        //3개 로또 중 5등 1개
                    WinningStatistics.from(lottos, WinningLotto.from(new String[] {"1", "2", "3", "24", "25", "26"}, LottoNumber.from(17))),
                        Math.round(5_000 / (double) 3000)
                ),
                Arguments.of(
                        //3개 로또 중 NOTING
                    WinningStatistics.from(lottos, WinningLotto.from(new String[] {"21", "22", "23", "24", "25", "26"}, LottoNumber.from(17))),
                        0.0
                )
        );
    }

}