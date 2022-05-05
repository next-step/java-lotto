package autolotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    private Lottos lottos;

    @BeforeEach
    void setUp() {
        lottos = new Lottos();
        lottos.add(new LottoNumbers(Set.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new LottoNumbers(Set.of(1, 2, 3, 4, 5, 43)));
    }

    @Test
    void returnCost() {
        assertThat(lottos.cost()).isEqualTo(2000);
    }
}
