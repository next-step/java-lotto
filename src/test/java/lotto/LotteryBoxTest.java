package lotto;

import lotto.model.LotteryBox;
import lotto.model.LotteryNumber;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryBoxTest {
    @Test
    void shouldShuffleBox() {
        List<LotteryNumber> shuffled1 = LotteryBox.shuffleBox();
        List<LotteryNumber> shuffled2 = LotteryBox.shuffleBox();
        assertThat(shuffled1).isNotEqualTo(shuffled2);
    }

    @Test
    void shouldFindSixNumbers() {
        assertThat(LotteryBox.findSixNumbers()).hasSize(6);
    }

    @Test
    void numbersShouldBeHashSet() {
        assertThat(LotteryBox.numbers).isInstanceOf(HashSet.class);
    }
}
