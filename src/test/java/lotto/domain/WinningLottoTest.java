package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class WinningLottoTest {

    @Test
    void 인풋이_제대로_되는지_확인한다() {
        assertThat(WinningLotto.of("1,2,3,4,5,8", 6)
                .matchRank(Lotto.of("1,2,3,4,5,6")))
                .isEqualTo(Rank.SECOND);
    }
}
