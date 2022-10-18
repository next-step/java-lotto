package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryTest {

    @Test
    @DisplayName("로또 추첨 사이즈 확인")
    void draw() {
        // given
        int size = 15;

        // when
        Lottery lottery = new Lottery(size);

        // then
        assertThat(lottery.getLottos().getLottoList()).hasSize(size);
    }

}
