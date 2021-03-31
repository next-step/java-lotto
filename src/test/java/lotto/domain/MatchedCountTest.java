package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchedCountTest {

    @Test
    @DisplayName("매칭된 수 객체 생성")
    public void create() throws Exception {
        MatchedCount matchedCount = new MatchedCount(3);
        assertThat(matchedCount).isEqualTo(new MatchedCount(3));
    }
}
