package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchTest {

    @DisplayName("정상 생성 테스트")
    @Test
    void valueOf() {
        assertThat(Match.valueOf(3)).isEqualTo(Match.THREE);
    }

}
