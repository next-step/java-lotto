package lotto.domain;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatcherTest {

    @Test
    void 로또_당첨_결과_확인() {
        WinnerNumbers winnerNumbers = new WinnerNumbers("1,2,3,4,5,6");
        Lotto matchOne = new Lotto("1,41,42,43,44,45");
        Lotto matchThree = new Lotto("1,2,3,43,44,45");
        Lotto matchFive = new Lotto("1,2,3,4,5,45");

        Map<Rank, Integer> winningStats = LottoMatcher.match(winnerNumbers, List.of(matchOne, matchThree, matchFive));
        assertThat(winningStats).containsEntry(Rank.FOURTH, 1);
        assertThat(winningStats).containsEntry(Rank.SECOND, 1);
    }
}
