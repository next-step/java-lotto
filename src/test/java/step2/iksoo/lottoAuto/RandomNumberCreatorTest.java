package step2.iksoo.lottoAuto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toCollection;
import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberCreatorTest {
    private final int LOTTO_SIZE = 6;

    private RandomNumberCreator randomCreator;
    private List<Integer> fullNumber;

    @BeforeEach
    void setUp() {
        randomCreator = new RandomNumberCreator();
        fullNumber = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(toCollection(ArrayList::new));
    }

    @Test
    void create_45까지_숫자() {
        IntStream.range(0, LOTTO_SIZE)
                .boxed()
                .peek(e -> assertThat(fullNumber).contains(randomCreator.getLotto(LOTTO_SIZE).get(e)));
    }
}
