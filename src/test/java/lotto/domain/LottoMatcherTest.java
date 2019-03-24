package lotto.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatcherTest {

    @Test
    public void 당첨결과_보너스번호없음() {
        final Lotto anyLotto = new Lotto(Arrays.asList(
                LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6)));

        final WinningLotto winningLotto = new WinningLotto(anyLotto);

        final LottoList lottos = new LottoList(Arrays.asList(
                anyLotto, // 6개 일치
                new Lotto(Arrays.asList( // 4개 일치
                        LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                        LottoNumber.from(4), LottoNumber.from(44), LottoNumber.from(45))),
                new Lotto(Arrays.asList( // 4개 일치
                        LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                        LottoNumber.from(4), LottoNumber.from(44), LottoNumber.from(45))),
                new Lotto(Arrays.asList( // 3개 일치
                        LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                        LottoNumber.from(43), LottoNumber.from(44), LottoNumber.from(45)))));

        final MatchResults matchResults = LottoMatcher.calculateMatchResults(lottos, winningLotto);

        assertThat(matchResults.get(Rank.FIRST)).isEqualTo(new RankCount(Rank.FIRST, 1));
        assertThat(matchResults.get(Rank.SECOND)).isEqualTo(new RankCount(Rank.SECOND, 0));
        assertThat(matchResults.get(Rank.THIRD)).isEqualTo(new RankCount(Rank.THIRD, 0));
        assertThat(matchResults.get(Rank.FOURTH)).isEqualTo(new RankCount(Rank.FOURTH, 2));
        assertThat(matchResults.get(Rank.FIFTH)).isEqualTo(new RankCount(Rank.FIFTH, 1));
    }

    @Test
    public void 당첨결과_보너스번호있음() {
        final Lotto anyLotto = new Lotto(Arrays.asList(
                LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6)));

        final WinningLotto winningLotto = new WinningLotto(anyLotto, LottoNumber.from(43));

        final LottoList lottos = new LottoList(Arrays.asList(
                anyLotto, // 6개 일치
                new Lotto(Arrays.asList( // 5개 일치 + 보너스 번호 일치
                        LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                        LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(43))),
                new Lotto(Arrays.asList( // 4개 일치
                        LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                        LottoNumber.from(4), LottoNumber.from(44), LottoNumber.from(45))),
                new Lotto(Arrays.asList( // 3개 일치
                        LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                        LottoNumber.from(43), LottoNumber.from(44), LottoNumber.from(45)))));

        final MatchResults matchResults = LottoMatcher.calculateMatchResults(lottos, winningLotto);

        assertThat(matchResults.get(Rank.FIRST)).isEqualTo(new RankCount(Rank.FIRST, 1));
        assertThat(matchResults.get(Rank.SECOND)).isEqualTo(new RankCount(Rank.SECOND, 1));
        assertThat(matchResults.get(Rank.THIRD)).isEqualTo(new RankCount(Rank.THIRD, 0));
        assertThat(matchResults.get(Rank.FOURTH)).isEqualTo(new RankCount(Rank.FOURTH, 1));
        assertThat(matchResults.get(Rank.FIFTH)).isEqualTo(new RankCount(Rank.FIFTH, 1));
    }
}