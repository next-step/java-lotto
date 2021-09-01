package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {
    @DisplayName("구입한 금액에 따라 로또를 자동으로 생성한다")
    @Test
    void autoPublish() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        int expected = 3;
        List<Lotto> lottos = lottoGenerator.autoPublish(expected);

        assertEquals(expected, lottos.size());
    }

}