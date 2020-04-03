package lotto;

import lotto.model.GameResult;
import lotto.model.Rank;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.model.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {
    @Test
    void getStatisticsTest() {
        //given
        List<Rank> ranks = Arrays.asList(BLANK, SECOND, FIFTH, BLANK, BLANK);

        //when
        GameResult gameResult = new GameResult(ranks);

        //then
        assertThat(gameResult.getEarningRate()).isEqualTo(600100.0);
        assertThat(gameResult.getResults().getCount(BLANK)).isEqualTo(3);
    }
}
