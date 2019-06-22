package step2.iksoo.lottoAuto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottosTest {
    private final int numberOfLottos = 3;
    private Lottos lottos;

    @Test
    void setUp() {
        List<Lotto> lottoList = new ArrayList<>();
        IntStream.range(0, numberOfLottos)
                .boxed()
                .peek(e -> lottoList.add(new Lotto()));

        lottos = new Lottos(lottoList);
    }

    @Test
    void 로또_세개() {

    }
}
