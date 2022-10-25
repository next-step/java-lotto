package lotto;

import lotto.domain.RandomNumberGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    @Test
    void 주어진_바운드_안에서_랜덤한_숫자를_생성한다() {
        assertThat(new RandomNumberGenerator(1, 45).generate()).isBetween(0, 45);
    }

}
