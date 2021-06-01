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
        pair.addMatchCountPair(MatchCount.THREE_MATCH);
        pair.addMatchCountPair(MatchCount.FOUR_MATCH);

        //then
        assertAll(
                () -> assertThat(pair.get(MatchCount.THREE_MATCH)).isEqualTo(1),
                () -> assertThat(pair.get(MatchCount.FOUR_MATCH)).isEqualTo(1),
                () -> assertThat(pair.get(MatchCount.FIVE_MATCH)).isEqualTo(0),
                () -> assertThat(pair.get(MatchCount.SIX_MATCH)).isEqualTo(0)
        );
    }
}
