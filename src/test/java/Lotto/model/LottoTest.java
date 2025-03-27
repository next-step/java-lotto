package Lotto.model;

import Lotto.model.NumberExtractor.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private static final int NUMBER_SIZE = 6;
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;

    @Test
    void shouldReturnSixNumbers() {
        NumberExtractor extractor = new RandomNumberExtractor();
        Lotto lotto = new Lotto(extractor);
        lotto.draw(NUMBER_SIZE, MIN_NUM, MAX_NUM);
        List<Integer> numbers = lotto.numbers();

        assertThat(numbers.size()).isEqualTo(6);
    }

    @Test
    void shouldReturnBetween1And45() {
        NumberExtractor extractor = new RandomNumberExtractor();
        Lotto lotto = new Lotto(extractor);
        lotto.draw(NUMBER_SIZE, MIN_NUM, MAX_NUM);
        List<Integer> numbers = lotto.numbers();

        for (int num : numbers) {
            assertThat(num).isBetween(1, 45);
        }
    }

    @Test
    void shouldBeZeroMatched() {
        int[] winNumbers = {1, 2, 3, 4, 5, 6};
        NumberExtractor extractor = new FixedNumberExtractor(new int[]{7,8,9,10,11,12});
        Lotto lotto = new Lotto(extractor);
        lotto.draw(NUMBER_SIZE, MIN_NUM, MAX_NUM);

        assertThat(lotto.checkMatched(winNumbers)).isEqualTo(0);
    }

    @Test
    void shouldBeThreeMatched() {
        int[] winNumbers = {1, 2, 3, 4, 5, 6};
        NumberExtractor extractor = new FixedNumberExtractor(new int[]{4,5,6,7,8,9});
        Lotto lotto = new Lotto(extractor);
        lotto.draw(NUMBER_SIZE, MIN_NUM, MAX_NUM);

        assertThat(lotto.checkMatched(winNumbers)).isEqualTo(3);
    }

    @Test
    void shouldBeSixMatched() {
        int[] winNumbers = {1, 2, 3, 4, 5, 6};
        NumberExtractor extractor = new FixedNumberExtractor(new int[]{1, 2, 3, 4, 5, 6});
        Lotto lotto = new Lotto(extractor);
        lotto.draw(NUMBER_SIZE, MIN_NUM, MAX_NUM);

        assertThat(lotto.checkMatched(winNumbers)).isEqualTo(6);
    }
}
