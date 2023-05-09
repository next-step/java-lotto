package step2;

import org.junit.jupiter.api.Test;
import step2.domain.Match;
import step2.domain.MatchRecord;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchRecordTest {

    @Test
    void 당첨_번호와_일치하는_개수를_맵_형태로_반환한다() {

        // given
        List<Match> matches = Arrays.asList(
                Match.from(3, false),
                Match.from(3, false),
                Match.from(5, true),
                Match.from(6, false)
        );

        MatchRecord matchRecord = MatchRecord.createRecord();

        // when
        Map<Match, Integer> result = matchRecord.countMatches(matches);

        // then
        assertThat(result).containsEntry(Match.from(3, false), 2);
        assertThat(result).containsEntry(Match.from(4, false), 0);
        assertThat(result).containsEntry(Match.from(5, true), 1);
        assertThat(result).containsEntry(Match.from(6, false), 1);
    }
}
