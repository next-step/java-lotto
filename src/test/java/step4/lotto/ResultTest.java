package step4.lotto;

import org.junit.jupiter.api.Test;
import step4.lotto.domain.Count;
import step4.lotto.domain.Rank;
import step4.lotto.domain.Result;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @Test
    void 로또_1등_2회() {
        Result result = new Result();
        result.plusRankCount(Rank.FIRST);
        result.plusRankCount(Rank.FIRST);

        assertThat(result.getRankCount(Rank.FIRST)).isEqualTo(new Count(2));
    }

    @Test
    void 로또_1등_3회일때_나머지_등수_갯수() {
        Result result = new Result();
        result.plusRankCount(Rank.FIRST);
        result.plusRankCount(Rank.FIRST);
        result.plusRankCount(Rank.FIRST);

        Count zero = new Count();
        for(Rank rank : Rank.values()){
            if(rank != Rank.FIRST){
                assertThat(result.getRankCount(rank)).isEqualTo(zero);
            }
        }
    }


}
