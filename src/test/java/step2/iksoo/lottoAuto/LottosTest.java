package step2.iksoo.lottoAuto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    private final int numberOfLottos = 3;
    private final List<Integer> WINNER_NUMBERS = Arrays.asList(new Integer[] {1, 2, 3, 4, 5, 6});

    private Lottos lottos;

    @BeforeEach
    public void setUp() {
        List<Lotto> lottoList = new ArrayList<>();
        IntStream.range(0, numberOfLottos)
                .forEach(e -> lottoList.add(new Lotto()));
        lottos = new Lottos(lottoList);
    }
}
