package step2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LottosTest {

    private final NumberGenerator numberGenerator = new RandomNumberGenerator();

    @Test
    void 로또를_수동으로_구매하면_검증_후_정상적으로_구매된다() {
        List<String> numbers = Arrays.asList(
                "1, 2, 3, 4, 5, 6",
                "7, 8, 9, 10, 11, 12",
                "13, 14, 15, 16, 17, 18"
        );

        Lottos lottos = Lottos.buyManualLottos(numbers, numberGenerator);

        assertNotNull(lottos);
        assertEquals(3, lottos.getLottos().size());

        List<Lotto> lottoList = lottos.getLottos();
        assertEquals("1, 2, 3, 4, 5, 6", lottoList.get(0).getLottoNumberString());
        assertEquals("7, 8, 9, 10, 11, 12", lottoList.get(1).getLottoNumberString());
        assertEquals("13, 14, 15, 16, 17, 18", lottoList.get(2).getLottoNumberString());
    }
}
