package lotto;

import lotto.model.LotteryBox;
import lotto.model.LotteryNumber;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryBoxTest {
    @Test
    void shouldShuffleBox() {
        List<LotteryNumber> origin = new ArrayList<>(LotteryBox.numbers);
        LotteryBox.shuffleBox();
        List<LotteryNumber> shuffled = LotteryBox.numbers;
        assertThat(origin).isNotEqualTo(shuffled);
    }

    @Test
    void shouldFindSixNumbers() {
        assertThat(LotteryBox.createLottery()).hasSize(6);
    }

    @Test
    void numbersShouldBeList() {
        assertThat(LotteryBox.numbers).isInstanceOf(List.class);
    }
}
