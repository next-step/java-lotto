package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static lotto.fixture.BuyerFixture.LOTTOES_BUY_COUNT_FIXTURE;
import static lotto.model.enums.Ranking.*;

public class RankingsTest {

    @Test
    void 수익률을_출력한다() {
        Rankings rankings = new Rankings(Map.of(
                FOURTH, 1,
                THIRD, 0,
                SECOND, 0,
                FIRST, 1
        ));
        double actual = rankings.statistics(LOTTOES_BUY_COUNT_FIXTURE);
        double expected = (Long.valueOf(2000000000L).doubleValue() + Long.valueOf(5000L).doubleValue()) / Integer.valueOf(14000).doubleValue();

        Assertions.assertThat(actual).isEqualTo(expected);
    }

}
