package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class AnalystTest {
    static Stream<Arguments> getCountByRankOneLottoParam() {
        LottoNumber winNumber = new LottoNumber(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        BonusNumber bonusNumber = new BonusNumber(20, winNumber);
        return Stream.of(
                Arguments.arguments(
                        List.of(new LottoNumber(new ArrayList<>(List.of(7, 8, 9, 10, 11, 12)))),
                        winNumber,
                        bonusNumber,
                        Map.of(
                                Rank.FIRST, 0L,
                                Rank.SECOND, 0L,
                                Rank.THIRD, 0L,
                                Rank.FOURTH, 0L,
                                Rank.FIFTH, 0L,
                                Rank.MISS, 1L)
                ),
                Arguments.arguments(
                        List.of(new LottoNumber(new ArrayList<>(List.of(1, 8, 9, 10, 11, 12)))),
                        winNumber,
                        bonusNumber,
                        Map.of(
                                Rank.FIRST, 0L,
                                Rank.SECOND, 0L,
                                Rank.THIRD, 0L,
                                Rank.FOURTH, 0L,
                                Rank.FIFTH, 0L,
                                Rank.MISS, 1L)
                ),
                Arguments.arguments(
                        List.of(new LottoNumber(new ArrayList<>(List.of(1, 2, 9, 10, 11, 12)))),
                        winNumber,
                        bonusNumber,
                        Map.of(
                                Rank.FIRST, 0L,
                                Rank.SECOND, 0L,
                                Rank.THIRD, 0L,
                                Rank.FOURTH, 0L,
                                Rank.FIFTH, 0L,
                                Rank.MISS, 1L)
                ),
                Arguments.arguments(
                        List.of(new LottoNumber(new ArrayList<>(List.of(1, 2, 3, 10, 11, 12)))),
                        winNumber,
                        bonusNumber,
                        Map.of(
                                Rank.FIRST, 0L,
                                Rank.SECOND, 0L,
                                Rank.THIRD, 0L,
                                Rank.FOURTH, 0L,
                                Rank.FIFTH, 1L,
                                Rank.MISS, 0L)
                ),
                Arguments.arguments(
                        List.of(new LottoNumber(new ArrayList<>(List.of(1, 2, 3, 4, 11, 12)))),
                        winNumber,
                        bonusNumber,
                        Map.of(
                                Rank.FIRST, 0L,
                                Rank.SECOND, 0L,
                                Rank.THIRD, 0L,
                                Rank.FOURTH, 1L,
                                Rank.FIFTH, 0L,
                                Rank.MISS, 0L)
                ),
                Arguments.arguments(
                        List.of(new LottoNumber(new ArrayList<>(List.of(1, 2, 3, 4, 5, 12)))),
                        winNumber,
                        bonusNumber,
                        Map.of(
                                Rank.FIRST, 0L,
                                Rank.SECOND, 0L,
                                Rank.THIRD, 1L,
                                Rank.FOURTH, 0L,
                                Rank.FIFTH, 0L,
                                Rank.MISS, 0L)
                ),
                Arguments.arguments(
                        List.of(new LottoNumber(new ArrayList<>(List.of(1, 2, 3, 4, 5, 20)))),
                        winNumber,
                        bonusNumber,
                        Map.of(
                                Rank.FIRST, 0L,
                                Rank.SECOND, 1L,
                                Rank.THIRD, 0L,
                                Rank.FOURTH, 0L,
                                Rank.FIFTH, 0L,
                                Rank.MISS, 0L)
                ),
                Arguments.arguments(
                        List.of(new LottoNumber(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)))),
                        winNumber,
                        bonusNumber,
                        Map.of(
                                Rank.FIRST, 1L,
                                Rank.SECOND, 0L,
                                Rank.THIRD, 0L,
                                Rank.FOURTH, 0L,
                                Rank.FIFTH, 0L,
                                Rank.MISS, 0L)
                )
        );
    }

    @DisplayName("로또를 한개 구입한 경우 맞춘수별 개수 계산")
    @ParameterizedTest(name = "{displayName} {index} 로또번호: {0} |당첨번호: {1} |보너스번호: {2}")
    @MethodSource("getCountByRankOneLottoParam")
    void getCountByRankOneLotto(List<LottoNumber> LottoNumbers, LottoNumber winNumber, BonusNumber bonusNumber, Map<Integer, Long> expectedCountByRank) {
        Analyst analyst = new Analyst(LottoNumbers, winNumber, bonusNumber);
        Map<Rank, Long> countByRank = analyst.getCountByRanks();
        Set<Map.Entry<Rank, Long>> countByRankEntrySets = countByRank.entrySet();
        Set<Map.Entry<Integer, Long>> expectedEntrySet = expectedCountByRank.entrySet();
        countByRankEntrySets.forEach(countByRankEntrySet -> assertThat(countByRankEntrySet).isIn(expectedEntrySet));
    }

    static Stream<Arguments> getCountByRankMultiLottoParam() {
        LottoNumber winNumber = new LottoNumber(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        BonusNumber bonusNumber = new BonusNumber(20, winNumber);
        return Stream.of(
                Arguments.arguments(
                        List.of(
                                new LottoNumber(new ArrayList<>(List.of(7, 8, 9, 10, 11, 12))),
                                new LottoNumber(new ArrayList<>(List.of(7, 8, 9, 10, 11, 12)))
                        ),
                        winNumber,
                        bonusNumber,
                        Map.of(
                                Rank.FIRST, 0L,
                                Rank.SECOND, 0L,
                                Rank.THIRD, 0L,
                                Rank.FOURTH, 0L,
                                Rank.FIFTH, 0L,
                                Rank.MISS, 2L)
                ),
                Arguments.arguments(
                        List.of(
                                new LottoNumber(new ArrayList<>(List.of(1, 2, 3, 10, 11, 12))),
                                new LottoNumber(new ArrayList<>(List.of(1, 2, 3, 10, 11, 12)))
                        ),
                        winNumber,
                        bonusNumber,
                        Map.of(
                                Rank.FIRST, 0L,
                                Rank.SECOND, 0L,
                                Rank.THIRD, 0L,
                                Rank.FOURTH, 0L,
                                Rank.FIFTH, 2L,
                                Rank.MISS, 0L)
                ),
                Arguments.arguments(
                        List.of(
                                new LottoNumber(new ArrayList<>(List.of(7, 8, 9, 10, 11, 12))),
                                new LottoNumber(new ArrayList<>(List.of(1, 8, 9, 10, 11, 12))),
                                new LottoNumber(new ArrayList<>(List.of(1, 2, 9, 10, 11, 12))),
                                new LottoNumber(new ArrayList<>(List.of(1, 2, 3, 10, 11, 12))),
                                new LottoNumber(new ArrayList<>(List.of(1, 2, 3, 4, 11, 12))),
                                new LottoNumber(new ArrayList<>(List.of(1, 2, 3, 4, 5, 12))),
                                new LottoNumber(new ArrayList<>(List.of(1, 2, 3, 4, 5, 20))),
                                new LottoNumber(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)))
                        ),
                        winNumber,
                        bonusNumber,
                        Map.of(
                                Rank.FIRST, 1L,
                                Rank.SECOND, 1L,
                                Rank.THIRD, 1L,
                                Rank.FOURTH, 1L,
                                Rank.FIFTH, 1L,
                                Rank.MISS, 3L)
                )
        );
    }

    @DisplayName("로또를 두개이상 산 경우 맞춘수별 개수 계산")
    @ParameterizedTest(name = "{displayName} {index} 로또번호: {0} |당첨번호: {1} |보너스번호: {2}")
    @MethodSource("getCountByRankMultiLottoParam")
    void getCountByRankMultiLotto(List<LottoNumber> LottoNumbers, LottoNumber winNumber, BonusNumber bonusNumber, Map<Integer, Long> expectedCountByRank) {
        Analyst analyst = new Analyst(LottoNumbers, winNumber, bonusNumber);
        Map<Rank, Long> countByRank = analyst.getCountByRanks();
        Set<Map.Entry<Rank, Long>> countByRankEntrySets = countByRank.entrySet();
        Set<Map.Entry<Integer, Long>> expectedEntrySet = expectedCountByRank.entrySet();
        countByRankEntrySets.forEach(countByRankEntrySet -> assertThat(countByRankEntrySet).isIn(expectedEntrySet));
    }

    static Stream<Arguments> revenueRatioOneLottoParam() {
        LottoNumber winNumber = new LottoNumber(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        BonusNumber bonusNumber = new BonusNumber(20, winNumber);
        return Stream.of(
                Arguments.arguments(
                        List.of(new LottoNumber(new ArrayList<>(List.of(7, 8, 9, 10, 11, 12)))),
                        winNumber,
                        bonusNumber,
                        0.0f
                ),
                Arguments.arguments(
                        List.of(new LottoNumber(new ArrayList<>(List.of(1, 2, 3, 10, 11, 12)))),
                        winNumber,
                        bonusNumber,
                        5.0f
                ),
                Arguments.arguments(
                        List.of(new LottoNumber(new ArrayList<>(List.of(1, 2, 3, 4, 11, 12)))),
                        winNumber,
                        bonusNumber,
                        50.0f
                ),
                Arguments.arguments(
                        List.of(new LottoNumber(new ArrayList<>(List.of(1, 2, 3, 4, 5, 12)))),
                        winNumber,
                        bonusNumber,
                        1_500.0f
                ),
                Arguments.arguments(
                        List.of(new LottoNumber(new ArrayList<>(List.of(1, 2, 3, 4, 5, 20)))),
                        winNumber,
                        bonusNumber,
                        30_000.0f
                ),
                Arguments.arguments(
                        List.of(new LottoNumber(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)))),
                        winNumber,
                        bonusNumber,
                        2_000_000.0f
                )
        );
    }

    @DisplayName("로또를 한개산 경우 수익률 계산")
    @ParameterizedTest(name = "{displayName} {index} 로또번호: {0} |당첨번호: {1} |보너스번호: {2}")
    @MethodSource("revenueRatioOneLottoParam")
    void revenueRatioOneLotto(List<LottoNumber> LottoNumbers, LottoNumber winNumber, BonusNumber bonusNumber, float expectedRatio) {
        Analyst analyst = new Analyst(LottoNumbers, winNumber, bonusNumber);
        float revenueRatio = analyst.revenueRatio(analyst.getCountByRanks());
        assertThat(revenueRatio).isEqualTo(expectedRatio);

    }

    static Stream<Arguments> revenueRatioMultiLottoParam() {
        LottoNumber winNumber = new LottoNumber(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        BonusNumber bonusNumber = new BonusNumber(20, winNumber);
        return Stream.of(
                Arguments.arguments(
                        List.of(
                                new LottoNumber(new ArrayList<>(List.of(7, 8, 9, 10, 11, 12))),
                                new LottoNumber(new ArrayList<>(List.of(7, 8, 9, 10, 11, 12)))
                        ),
                        winNumber,
                        bonusNumber,
                        0.0f
                ),
                Arguments.arguments(
                        List.of(
                                new LottoNumber(new ArrayList<>(List.of(1, 2, 3, 10, 11, 12))),
                                new LottoNumber(new ArrayList<>(List.of(1, 2, 3, 10, 11, 12)))
                        ),
                        winNumber,
                        bonusNumber,
                        5.0f
                ),
                Arguments.arguments(
                        List.of(
                                new LottoNumber(new ArrayList<>(List.of(7, 8, 9, 10, 11, 12))),
                                new LottoNumber(new ArrayList<>(List.of(1, 8, 9, 10, 11, 12))),
                                new LottoNumber(new ArrayList<>(List.of(1, 2, 9, 10, 11, 12))),
                                new LottoNumber(new ArrayList<>(List.of(1, 2, 3, 10, 11, 12))),
                                new LottoNumber(new ArrayList<>(List.of(1, 2, 3, 4, 11, 12))),
                                new LottoNumber(new ArrayList<>(List.of(1, 2, 3, 4, 5, 12))),
                                new LottoNumber(new ArrayList<>(List.of(1, 2, 3, 4, 5, 20))),
                                new LottoNumber(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)))
                        ),
                        winNumber,
                        bonusNumber,
                        2031555.0f / 8
                )
        );
    }

    @DisplayName("로또를 두개이상 산 경우 수익률 계산")
    @ParameterizedTest(name = "{displayName} {index} 로또번호: {0} |당첨번호: {1} |보너스번호: {2}")
    @MethodSource("revenueRatioMultiLottoParam")
    void revenueRatioMultiLotto(List<LottoNumber> gambleHistory, LottoNumber winNumber, BonusNumber bonusNumber, float expectedRatio) {
        Analyst analyst = new Analyst(gambleHistory, winNumber, bonusNumber);
        float revenueRatio = analyst.revenueRatio(analyst.getCountByRanks());
        assertThat(revenueRatio).isEqualTo(expectedRatio);

    }
}