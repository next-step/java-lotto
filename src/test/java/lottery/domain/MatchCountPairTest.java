package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class MatchCountPairTest {

    @Test
    @DisplayName("맞춘 개수에 대한 건수를 증가시킨다.")
    void matchAll_test() {
        //given
        MatchCountPair pair = new MatchCountPair();

        //when
        pair.addMatchCountPair(MatchCount.THREE);
        pair.addMatchCountPair(MatchCount.FOUR);

        //then
        assertAll(
                () -> assertThat(pair.countByMatchCount(MatchCount.THREE)).isEqualTo(1),
                () -> assertThat(pair.countByMatchCount(MatchCount.FOUR)).isEqualTo(1),
                () -> assertThat(pair.countByMatchCount(MatchCount.FIVE)).isEqualTo(0),
                () -> assertThat(pair.countByMatchCount(MatchCount.SIX)).isEqualTo(0)
        );
    }
}
