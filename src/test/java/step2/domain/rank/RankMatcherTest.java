package step2.domain.rank;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.lotto.Lotto;
import step2.domain.lotto.LottoRule;
import step2.domain.lotto.WinningLotto;
import step2.domain.rank.rankmatcher.GeneralRankMatcher;
import step2.domain.rank.rankmatcher.SecondRankMatcher;

import java.util.List;

class RankMatcherTest {
    public static final LottoRule LOTTO_RULE = new LottoRule(1, 45, 6);

    @DisplayName("GeneralRank matches 테스트")
    @Test
    void matchesTest() {
        // given
        Lotto givenLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6), LOTTO_RULE);
        WinningLotto winningLotto = new WinningLotto(givenLotto, 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6), LOTTO_RULE);
        int requiredMatches = 6;

        // when
        RankMatcher rankMatcher = new GeneralRankMatcher(requiredMatches);

        // then
        boolean actual = rankMatcher.matches(winningLotto, lotto);
        Assertions.assertThat(actual).isTrue();
    }


    @DisplayName("GeneralRank matches 실패 테스트")
    @Test
    void matchesFailTest() {
        // given
        int bonusNumber = 7;
        Lotto givenLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6), LOTTO_RULE);
        WinningLotto winningLotto = new WinningLotto(givenLotto, bonusNumber);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8), LOTTO_RULE);
        int requiredMatches = 6;

        // when
        RankMatcher rankMatcher = new GeneralRankMatcher(requiredMatches);

        // then
        boolean actual = rankMatcher.matches(winningLotto, lotto);
        Assertions.assertThat(actual).isFalse();
    }


    @DisplayName("SecondRank matches 테스트")
    @Test
    void secondRankMatchesTest() {
        // given
        int bonusNumber = 7;
        Lotto givenLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6), LOTTO_RULE);
        WinningLotto winningLotto = new WinningLotto(givenLotto, bonusNumber);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7), LOTTO_RULE);

        // when
        RankMatcher rankMatcher = new SecondRankMatcher();

        // then
        boolean actual = rankMatcher.matches(winningLotto, lotto);
        Assertions.assertThat(actual).isTrue();
    }

    @DisplayName("SecondRank matches 실패 테스트")
    @Test
    void secondRankMatchesFailTest() {
        // given
        int bonusNumber = 7;
        Lotto givenLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6), LOTTO_RULE);
        WinningLotto winningLotto = new WinningLotto(givenLotto, bonusNumber);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8), LOTTO_RULE);

        // when
        RankMatcher rankMatcher = new SecondRankMatcher();

        // then
        boolean actual = rankMatcher.matches(winningLotto, lotto);
        Assertions.assertThat(actual).isFalse();
    }
}