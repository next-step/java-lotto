package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomShuffleTest {

    @Test
    @DisplayName("매번 shuffle된 List가 생성된다")
    void shuffle_test() {
        DefaultNumbers defaultNumbers = new DefaultNumbers();
        RandomShuffle randomShuffle1 = new RandomShuffle();
        assertThat(randomShuffle1.of(defaultNumbers)).isNotEqualTo(randomShuffle1.of(defaultNumbers));
    }

}
