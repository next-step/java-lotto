package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningTest {

    @Test
    void 생성() {
        Winning winning = new Winning(Rank.FIRST);
        assertThat(winning).isEqualTo(new Winning(Rank.FIRST));
    }
}
