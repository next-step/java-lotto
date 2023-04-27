package step2;

import org.junit.jupiter.api.Test;
import step2.domain.Match;
import step2.domain.MatchRecord;
import step2.domain.Number;

import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static step2.domain.MatchFactory.match;

public class MatchRecordTest {

    @Test
    void 당첨_번호와_일치하는_개수를_리스트로_반환한다() {

        // given
        MatchRecord matchRecord = MatchRecord.createRecord();
        List<List<Integer>> purchaseNumbers = asList(
                asList(1, 2, 3, 4, 5, 6),
                asList(2, 3 ,4, 5, 6, 7),
                asList(4, 5, 6, 8, 11, 13),
                asList(4, 5, 6, 8, 11, 12)
        );

        List<Integer> winningNumbers = asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        Number lottoNumber = new Number(winningNumbers, bonusNumber);

        // when
        Map<Match, Integer> result = matchRecord.countNumber(purchaseNumbers, lottoNumber);

        // then
        assertThat(result).containsEntry(match(3, false), 2);
        assertThat(result).containsEntry(match(4, false), 0);
        assertThat(result).containsEntry(match(5, true), 1);
        assertThat(result).containsEntry(match(6, false), 1);

    }
}
