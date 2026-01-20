package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ManualLottoGeneratorTest {

    @Test
    void manual_generate_size() {
        List<Lotto> list = List.of(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(2, 3, 4, 5, 6, 7)
        );
        ManualLottoGenerator manual = new ManualLottoGenerator(list);
        Lottos generate = manual.generate();
        assertThat(generate.size()).isEqualTo(2);
    }
}