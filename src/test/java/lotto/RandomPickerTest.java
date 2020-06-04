package lotto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomPickerTest {
    private static List<Integer> lotto;
    @BeforeAll
    static void beforeAll() {
        RandomPicker randomPicker = new RandomPicker();
        lotto = randomPicker.pickRandomLotto();
    }

    @Test
    void pickLottoSizeTest() {
        assertThat(lotto.size()).isEqualTo(6);
    }

    @Test
    void pickLottoNotContainTest() {
        assertThat(lotto).doesNotContain(0, 46);
    }
}
