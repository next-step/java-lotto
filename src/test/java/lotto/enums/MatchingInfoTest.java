package lotto.enums;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchingInfoTest {


    @Test
    void 이넘_테스트() {
        MatchingInfo matchZero = MatchingInfo.MATCH_ZERO;
        MatchingInfo matchSix = MatchingInfo.MATCH_SIX;

        assertThat(matchZero.getPayout()).isEqualTo(0);
        assertThat(matchSix.getPayout()).isEqualTo(2000000000);
    }

    @Test
    void 매칭정보_반환_테스트() {
        assertThat(MatchingInfo.matchingInfo(4,true).getPayout()).isEqualTo(50_000);
        assertThat(MatchingInfo.matchingInfo(4,false).getPayout()).isEqualTo(50_000);
        assertThat(MatchingInfo.matchingInfo(5,true).getPayout()).isEqualTo(30_000_000);
        assertThat(MatchingInfo.matchingInfo(5,false).getPayout()).isEqualTo(1_500_000);
    }
}
