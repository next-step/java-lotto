package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MatchCountTest {
    @Test
    @DisplayName("로또 번호 일치 개수는 0 이상 6 이하만 가능합니다.")
    void create() {
        Assertions.assertThatThrownBy(() -> new MatchCount(7))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new MatchCount(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호 6개 일치 가능하다.")
    void create_1() {
        MatchCount matchCount = new MatchCount(6);
        Assertions.assertThat(matchCount.value()).isEqualTo(6);
    }
}
