package src.domain;

import org.junit.jupiter.api.Test;
import src.domain.MatchStatus;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MatchStatusTest {

    @Test
    void 수익_금액을_알_수_있다() {
        // given
        Map<Place, Integer> matchStatusMap = Map.of(Place.FOURTH_PLACE, 1);
        double expectedProfit = 50000.0; // 4등(50000원) 1개

        // when
        MatchStatus matchStatus = MatchStatus.of(matchStatusMap);

        // then
        assertThat(matchStatus.profit()).isEqualTo(expectedProfit);
    }
}
