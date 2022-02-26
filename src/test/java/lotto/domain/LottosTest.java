package lotto.domain;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("수동_로또_개수_테스트")
    @Test
    void calculateNumberOfLottosAutomaticalTest() {
        Lottos lottos = new Lottos();
        int calculateNumberOfLottos = lottos.calculateNumberOfLottosAutomatical(3, new Money(14000));
        assertThat(calculateNumberOfLottos).isEqualTo(11);
    }
}
