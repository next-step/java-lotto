package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AutoCountTest {

    @Test
    void generate_lottos_automatically() {
        AutoCount autoCount = new AutoCount(5);
        List<Lotto> lottos = autoCount.buyLottos();

        assertThat(lottos).hasSize(5);
    }
}