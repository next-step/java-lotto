package lotto;

import lotto.model.Rank;
import lotto.model.gameresult.MatchResults;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.model.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MatchResultsTest {
    @DisplayName("구입한 로또의 Rank 목록을 주면 각각의 갯수를 가진 Results 객체를 생성한다.")
    @Test
    void reflectTest() {
        List<Rank> ranks = Arrays.asList(BLANK, SECOND, THIRD, BLANK, BLANK, BLANK);

        MatchResults matchResults = MatchResults.reflectAll(ranks);

        assertThat(matchResults.getCount(BLANK)).isEqualTo(4);
    }
}
