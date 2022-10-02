package lotto.model;

import org.junit.jupiter.api.Test;

import static lotto.model.MatchNumber.*;
import static org.assertj.core.api.Assertions.assertThat;

class MatchNumberTest {
    @Test
    void shouldGetMatchNumber() {
        assertThat(getMatchNumber(4, false)).isEqualTo(FOURTH);
        assertThat(getMatchNumber(5, false)).isEqualTo(THIRD);
        assertThat(getMatchNumber(5, true)).isEqualTo(SECOND);
    }
}
