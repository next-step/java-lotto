package step3.iksoo.lotto2rd;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberCreatorTest {
    private final int LOTTO_SIZE = 6;

    private RandomNumberCreator randomCreator = new RandomNumberCreator();

    @Test
    void create_45까지_숫자() {
        List<Integer> lotto = randomCreator.getLotto(LOTTO_SIZE);
        IntStream.range(0, LOTTO_SIZE)
                .boxed()
                .peek(e -> assertThat(lotto.get(e)).isBetween(RandomNumberCreator.START_NUMBER, RandomNumberCreator.END_NUMBER));
    }
}