package lotto.step2.domain;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {
    @Test
    @DisplayName("hasMatchingCount를 사용하면, 각 LottoRank의 matchingCount가 0 초과인지 확인한다.")
    void testHasMatchingCount() {
        SoftAssertions.assertSoftly(softly -> {
                    softly.assertThat(LottoRank.OTHER.hasMatchingCount()).isFalse();

                    softly.assertThat(LottoRank.FIFTH.hasMatchingCount()).isTrue();
                    softly.assertThat(LottoRank.FOURTH.hasMatchingCount()).isTrue();
                    softly.assertThat(LottoRank.THIRD.hasMatchingCount()).isTrue();
                    softly.assertThat(LottoRank.SECOND.hasMatchingCount()).isTrue();
                    softly.assertThat(LottoRank.FIRST.hasMatchingCount()).isTrue();
                }
        );
    }

    @Test
    @DisplayName("findByCount의 입력으로 일치하는 개수를 넣으면, 해당하는 LottoRank 객체를 반환한다.")
    void testGetDescription() {
        SoftAssertions.assertSoftly(softly -> {
                    softly.assertThat(LottoRank.OTHER.getDescription()).isEqualTo("탈락");
                    softly.assertThat(LottoRank.FIFTH.getDescription()).isEqualTo("5등");
                    softly.assertThat(LottoRank.FOURTH.getDescription()).isEqualTo("4등");
                    softly.assertThat(LottoRank.THIRD.getDescription()).isEqualTo("3등");
                    softly.assertThat(LottoRank.SECOND.getDescription()).isEqualTo("2등");
                    softly.assertThat(LottoRank.FIRST.getDescription()).isEqualTo("1등");
                }
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
