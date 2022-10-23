package step2.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    void 일치하는_개수를_입력하면_상금을_알_수_있다() {
        assertThat(Rank.prizeAmount(6)).isEqualTo(2_000_000_000);
    }
}
