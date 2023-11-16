package lotto.step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultsTest {
    private final static int FIRST_RANK_COUNT = 1;
    private final static int SECOND_RANK_COUNT = 2;
    private final static int THIRD_RANK_COUNT = 3;
    private final static int FOURTH_RANK_COUNT = 4;
    private final static int FIFTH_RANK_COUNT = 5;
    LottoResults lottoResults;

    @BeforeEach
    void setUp() {
        lottoResults = new LottoResults();

        putLottoResults(LottoRank.FIRST, FIRST_RANK_COUNT);
        putLottoResults(LottoRank.SECOND, SECOND_RANK_COUNT);
        putLottoResults(LottoRank.THIRD, THIRD_RANK_COUNT);
        putLottoResults(LottoRank.FOURTH, FOURTH_RANK_COUNT);
        putLottoResults(LottoRank.FIFTH, FIFTH_RANK_COUNT);
    }

    private void putLottoResults(final LottoRank lottoRank, final int firstRankCount) {
        for (int i = 0; i < firstRankCount; i++) {
            lottoResults.incrementRankCount(lottoRank);
        }
    }

    @ParameterizedTest
    @MethodSource("inputWithLottoRankAndRankCount")
    @DisplayName("getCount 메서드의 입력으로 LottoRank를 넣으면, LottoResults에서 해당 Rank가 몇개 존재하는지 반환한다.")
    void testGetCount(final LottoRank lottoRank, final int rankCount) {
        assertThat(lottoResults.getCount(lottoRank)).isEqualTo(rankCount);
    }


    @ParameterizedTest
    @MethodSource("inputWithLottoRankAndRankCount")
    @DisplayName("incrementRankCount 메서드의 입력으로 LottoRank를 넣으면, LottoResults에서 해당 Rank의 개수를 1개 증가시킨다.")
    void testIncrementRankCount(final LottoRank lottoRank, final int rankCount) {
        lottoResults.incrementRankCount(lottoRank);
        assertThat(lottoResults.getCount(lottoRank)).isEqualTo(rankCount + 1);
    }

    @Test
    @DisplayName("toString을 사용하면, 당첨 통계 값을 반환한다.")
    void testToString() {
        assertThat(lottoResults.toString())
                .isEqualTo(
                        LottoRank.FIFTH.getMatchingCount() + "개 일치 (" + LottoRank.FIFTH.getPrizeMoney() + "원)- " + FIFTH_RANK_COUNT + "개\n" +
                                LottoRank.FOURTH.getMatchingCount() + "개 일치 (" + LottoRank.FOURTH.getPrizeMoney() + "원)- " + FOURTH_RANK_COUNT + "개\n" +
                                LottoRank.THIRD.getMatchingCount() + "개 일치 (" + LottoRank.THIRD.getPrizeMoney() + "원)- " + THIRD_RANK_COUNT + "개\n" +
                                LottoRank.SECOND.getMatchingCount() + "개 일치,보너스 볼 일치 (" + LottoRank.SECOND.getPrizeMoney() + "원)- " + SECOND_RANK_COUNT + "개\n" +
                                LottoRank.FIRST.getMatchingCount() + "개 일치 (" + LottoRank.FIRST.getPrizeMoney() + "원)- " + FIRST_RANK_COUNT + "개\n"
                );
    }

    public static Stream<Arguments> inputWithLottoRankAndRankCount() {
        return Stream.of(
                Arguments.of(LottoRank.FIRST, FIRST_RANK_COUNT),
                Arguments.of(LottoRank.SECOND, SECOND_RANK_COUNT),
                Arguments.of(LottoRank.THIRD, THIRD_RANK_COUNT),
                Arguments.of(LottoRank.FOURTH, FOURTH_RANK_COUNT)
        );
    }

    @Test
    @DisplayName("getTotalPrizeMoney 메서드를 사용하면, 총 상금을 반환한다.")
    void testGetTotalPrizeMoney() {
        //given
        long expectedTotalPrizeMoney = getExpectedTotalPrizeMoney();

        //when
        long totalPrizeMoney = lottoResults.getTotalPrizeMoney();

        //then
        assertThat(totalPrizeMoney).isEqualTo(expectedTotalPrizeMoney);
    }

    private long getExpectedTotalPrizeMoney() {
        return (long) LottoRank.FIRST.getPrizeMoney() * FIRST_RANK_COUNT
                + (long) LottoRank.SECOND.getPrizeMoney() * SECOND_RANK_COUNT
                + (long) LottoRank.THIRD.getPrizeMoney() * THIRD_RANK_COUNT
                + (long) LottoRank.FOURTH.getPrizeMoney() * FOURTH_RANK_COUNT;
    }

    @Test
    @DisplayName("calculateRateOfReturn 메서드의 입력으로 구매 금액을 넣으면, 수익률을 반환한다.")
    void testCalculateRateOfReturn() {
        //given
        final int paymentAmount = 1000;
        final double expectedRateOfReturn = ((double) getExpectedTotalPrizeMoney()) / paymentAmount;

        //when
        final double rateOfReturn = lottoResults.calculateRateOfReturn(paymentAmount);

        //then
        assertThat(rateOfReturn).isEqualTo(expectedRateOfReturn);
    }


    @Test
    @DisplayName("calculateResults 메서드의 입력으로 Lotto List 와 winnerNumbers를 넣으면, 입력한 Lotto List의 당첨 통계를 구한다. - 1등 [당첨 번호 6개]")
    void testCheckLottoWinningNumbers_LottoRank_FIRST() {
        //given
        final LottoNumber bonusWinnerNumber = new LottoNumber(7);
        final Lotto winnerLotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));

        final WinnerNumbers winnerNumbers = new WinnerNumbers(winnerLotto, bonusWinnerNumber);
        final List<Lotto> lottos = List.of(new Lotto(Set.of(1, 2, 3, 4, 5, 6)));

        //when
        LottoResults lottoResults = LottoResults.calculateResults(lottos, winnerNumbers);

        //then
        assertThat(lottoResults.getCount(LottoRank.FIRST)).isEqualTo(1);
    }

    @Test
    @DisplayName("calculateResults 메서드의 입력으로 Lotto List 와 winnerNumbers를 넣으면, 입력한 Lotto List의 당첨 통계를 구한다. - 2등 [당첨 번호 5개, 보너스 번호 일치]")
    void testCheckLottoWinningNumbers_LottoRank_SECOND() {
        //given
        final LottoNumber bonusWinnerNumber = new LottoNumber(7);
        final Lotto winnerLotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));

        final WinnerNumbers winnerNumbers = new WinnerNumbers(winnerLotto, bonusWinnerNumber);
        final List<Lotto> lottos = List.of(
                new Lotto(Set.of(1, 2, 3, 4, 5, 7)),
                new Lotto(Set.of(1, 2, 3, 4, 6, 7)));

        //when
        LottoResults lottoResults = LottoResults.calculateResults(lottos, winnerNumbers);

        //then
        assertThat(lottoResults.getCount(LottoRank.SECOND)).isEqualTo(2);
    }

    @Test
    @DisplayName("calculateResults 메서드의 입력으로 Lotto List 와 winnerNumbers를 넣으면, 입력한 Lotto List의 당첨 통계를 구한다. - 3등 [당첨 번호 5개, 보너스 번호 불일치]")
    void testCheckLottoWinningNumbers_LottoRank_THIRD() {
        //given
        final LottoNumber bonusWinnerNumber = new LottoNumber(7);
        final Lotto winnerLotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));

        final WinnerNumbers winnerNumbers = new WinnerNumbers(winnerLotto, bonusWinnerNumber);
        final List<Lotto> lottos = List.of(
                new Lotto(Set.of(1, 2, 3, 4, 5, 8)),
                new Lotto(Set.of(1, 2, 3, 4, 6, 8)),
                new Lotto(Set.of(2, 3, 4, 5, 6, 8))
        );

        //when
        LottoResults lottoResults = LottoResults.calculateResults(lottos, winnerNumbers);

        //then
        assertThat(lottoResults.getCount(LottoRank.THIRD)).isEqualTo(3);
    }

    @Test
    @DisplayName("calculateResults 메서드의 입력으로 Lotto List 와 winnerNumbers를 넣으면, 입력한 Lotto List의 당첨 통계를 구한다. - 4등 [당첨 번호 4개]")
    void testCheckLottoWinningNumbers_LottoRank_FOURTH() {
        //given
        final LottoNumber bonusWinnerNumber = new LottoNumber(7);
        final Lotto winnerLotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));

        final WinnerNumbers winnerNumbers = new WinnerNumbers(winnerLotto, bonusWinnerNumber);
        final List<Lotto> lottos = List.of(
                new Lotto(Set.of(1, 2, 3, 4, 7, 8)),
                new Lotto(Set.of(2, 3, 4, 6, 7, 8)),
                new Lotto(Set.of(1, 2, 3, 4, 10, 11)),
                new Lotto(Set.of(3, 4, 5, 6, 8, 10))
        );

        //when
        LottoResults lottoResults = LottoResults.calculateResults(lottos, winnerNumbers);

        //then
        assertThat(lottoResults.getCount(LottoRank.FOURTH)).isEqualTo(4);
    }

    @Test
    @DisplayName("calculateResults 메서드의 입력으로 Lotto List 와 winnerNumbers를 넣으면, 입력한 Lotto List의 당첨 통계를 구한다. - 5등 [당첨 번호 3개]")
    void testCheckLottoWinningNumbers_LottoRank_FIFTH() {
        //given
        final LottoNumber bonusWinnerNumber = new LottoNumber(7);
        final Lotto winnerLotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));

        final WinnerNumbers winnerNumbers = new WinnerNumbers(winnerLotto, bonusWinnerNumber);
        final List<Lotto> lottos = List.of(
                new Lotto(Set.of(1, 2, 3, 7, 8, 10)),
                new Lotto(Set.of(2, 3, 4, 7, 8, 11)),
                new Lotto(Set.of(1, 2, 6, 7, 10, 11)),
                new Lotto(Set.of(3, 4, 6, 8, 10, 15)),
                new Lotto(Set.of(1, 3, 6, 10, 15, 33))
        );

        //when
        LottoResults lottoResults = LottoResults.calculateResults(lottos, winnerNumbers);

        //then
        assertThat(lottoResults.getCount(LottoRank.FIFTH)).isEqualTo(5);
    }
}
