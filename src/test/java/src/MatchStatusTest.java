package src;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MatchStatusTest {

    @Test
    void 수익_금액을_알_수_있다() {
        // given
        List<Integer> matchCounts = List.of(3, 2);
        double expectedProfit = 5000.0; // 4등(5000원) 1개

        // when
        MatchStatus matchStatus = MatchStatus.matchStatus(matchCounts);

        // then
        assertThat(matchStatus.profit()).isEqualTo(expectedProfit);

    }
}
