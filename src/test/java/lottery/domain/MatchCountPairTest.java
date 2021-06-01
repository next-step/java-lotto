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
        pair.addMatchCountPair(3);
        pair.addMatchCountPair(4);

        //then
        assertAll(
                () -> assertThat(pair.get(3)).isEqualTo(1),
                () -> assertThat(pair.get(4)).isEqualTo(1),
                () -> assertThat(pair.get(5)).isEqualTo(0),
                () -> assertThat(pair.get(6)).isEqualTo(0)
        );
    }
}
