package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutoLottoGeneratorTest {

    @Test
    void auto_generate_size() {
        AutoLottoGenerator auto = new AutoLottoGenerator(new LottoCount(3));
        Lottos generate = auto.generate();
        Assertions.assertThat(generate.size()).isEqualTo(3);
    }
}