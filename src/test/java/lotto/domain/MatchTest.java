package lotto.domain;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MatchTest {
    @Test
    void 로또_통계() {
        Match match = new Match(List.of(new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))), new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(7)))), LottoNumber.createWinningNumbers("1, 2, 3, 4, 5, 6"));
      List<Winning> winnings = new ArrayList<>();
      for (int matchCount = Match.THREE_MATCH; matchCount <= Match.SIX_MATCH; matchCount++) {
          Matches matches = match.winningNumber.countMatches(match.lottos);
        int winningCount = (int) matches.countMatches.stream()
                .filter(match1 -> matchCount == match1)
                .count();
        Winning winning = new Winning(matchCount, winningCount);
          winnings.add(winning);
      }
      assertThat(new Winnings(winnings)).isEqualTo(new Winnings(List.of(new Winning(3, 0), new Winning(4, 0), new Winning(5, 1), new Winning(6, 1))));
    }
}