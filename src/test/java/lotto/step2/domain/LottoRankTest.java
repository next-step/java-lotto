package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {
    @ParameterizedTest
    @MethodSource("inputLottoRankWithHasMatchingCountValueResult")
    @DisplayName("lottoRank 객체에서 hasMatchingCount를 사용하면, 해당 객체의 matchingCount가 0보다 큰 지 확인한다.")
    void testHasMatchingCountForOther(LottoRank lottoRank, boolean expected) {
        //given
        //when
        final boolean result = lottoRank.hasMatchingCount();

        //then
        assertThat(result).isEqualTo(expected);
    }

    public static Stream<Arguments> inputLottoRankWithHasMatchingCountValueResult() {
        return Stream.of(
                Arguments.of(LottoRank.OTHER, false),
                Arguments.of(LottoRank.FIFTH, true),
                Arguments.of(LottoRank.FOURTH, true),
                Arguments.of(LottoRank.THIRD, true),
                Arguments.of(LottoRank.SECOND, true),
                Arguments.of(LottoRank.FIRST, true)
        );
    }

    @ParameterizedTest
    @MethodSource("inputLottoRankWithDescription")
    @DisplayName("lottoRank 객체에서 getDescription를 사용하면, 해당 객체의 description을 반환한다.")
    void testGetDescription(LottoRank lottoRank, String expected) {
        //given
        //when
        final String result = lottoRank.getDescription();

        //then
        assertThat(result).isEqualTo(expected);
    }

    public static Stream<Arguments> inputLottoRankWithDescription() {
        return Stream.of(
                Arguments.of(LottoRank.OTHER, "탈락"),
                Arguments.of(LottoRank.FIFTH, "5등"),
                Arguments.of(LottoRank.FOURTH, "4등"),
                Arguments.of(LottoRank.THIRD, "3등"),
                Arguments.of(LottoRank.SECOND, "2등"),
                Arguments.of(LottoRank.FIRST, "1등")
        );
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("findByCountAndBonusMatching의 입력으로 5등에 해당하는 숫자 일치 개수를 넣으면, 보너스 일치 여부와 관계없이 5등에 해당하는 LottoRank 객체를 반환한다.")
    void testFindByCountAndBonusMatchingForFifthRank(boolean isBonusMatch) {
        // given
        int matchingCount = LottoRank.FIFTH.getMatchingCount();
        LottoRank expectedRank = LottoRank.FIFTH;

        // when
        LottoRank resultRank = LottoRank.findByCountAndBonusMatching(matchingCount, isBonusMatch);

        // then
        assertThat(resultRank).isEqualTo(expectedRank);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("findByCountAndBonusMatching의 입력으로 4등에 해당하는 숫자 일치 개수를 넣으면, 보너스 일치 여부와 관계없이 4등에 해당하는 LottoRank 객체를 반환한다.")
    void testFindByCountAndBonusMatchingForFourthRank(boolean isBonusMatch) {
        // given
        int matchingCount = LottoRank.FOURTH.getMatchingCount();
        LottoRank expectedRank = LottoRank.FOURTH;

        // when
        LottoRank resultRank = LottoRank.findByCountAndBonusMatching(matchingCount, isBonusMatch);

        // then
        assertThat(resultRank).isEqualTo(expectedRank);
    }

    @Test
    @DisplayName("findByCountAndBonusMatching의 입력으로 3등에 해당하는 숫자 일치 개수를 넣고 보너스가 일치하지 않으면, 3등에 해당하는 LottoRank 객체를 반환한다.")
    void testFindByCountAndBonusMatchingForThirdRank() {
        // given
        int matchingCount = LottoRank.THIRD.getMatchingCount();
        boolean isBonusMatch = false;
        LottoRank expectedRank = LottoRank.THIRD;

        // when
        LottoRank resultRank = LottoRank.findByCountAndBonusMatching(matchingCount, isBonusMatch);

        // then
        assertThat(resultRank).isEqualTo(expectedRank);
    }

    @Test
    @DisplayName("findByCountAndBonusMatching의 입력으로 2등에 해당하는 숫자 일치 개수를 넣고 보너스가 일치하면, 2등에 해당하는 LottoRank 객체를 반환한다.")
    void testFindByCountAndBonusMatchingForSecondRank() {
        // given
        int matchingCount = LottoRank.SECOND.getMatchingCount();
        boolean isBonusMatch = true;
        LottoRank expectedRank = LottoRank.SECOND;

        // when
        LottoRank resultRank = LottoRank.findByCountAndBonusMatching(matchingCount, isBonusMatch);

        // then
        assertThat(resultRank).isEqualTo(expectedRank);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("findByCountAndBonusMatching의 입력으로 1등에 해당하는 숫자 일치 개수를 넣으면, 보너스 일치 여부와 관계없이 1등에 해당하는 LottoRank 객체를 반환한다.")
    void testFindByCountAndBonusMatchingForFirstRank(boolean isBonusMatch) {
        // given
        int matchingCount = LottoRank.FIRST.getMatchingCount();
        LottoRank expectedRank = LottoRank.FIRST;

        // when
        LottoRank resultRank = LottoRank.findByCountAndBonusMatching(matchingCount, isBonusMatch);

        // then
        assertThat(resultRank).isEqualTo(expectedRank);
    }
}
