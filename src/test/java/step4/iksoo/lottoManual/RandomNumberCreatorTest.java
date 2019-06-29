package step4.iksoo.lottoManual;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberCreatorTest {

    private RandomNumberCreator randomCreator = new RandomNumberCreator();

    @Test
    void create_45까지_숫자() {
        List<Integer> lotto = randomCreator.getLotto(Lotto.LOTTO_SIZE);
        IntStream.range(0, Lotto.LOTTO_SIZE)
                .boxed()
                .peek(e -> assertThat(lotto.get(e)).isBetween(RandomNumberCreator.START_NUMBER, RandomNumberCreator.END_NUMBER));
    }
}