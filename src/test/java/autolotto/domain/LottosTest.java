package autolotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    private Lottos lottos;

    @BeforeEach
    void setUp() {
        LottoNumbers lottoNumbers1 = new LottoNumbers(Set.of(1, 2, 3, 4, 5, 6));
        LottoNumbers lottoNumbers2 = new LottoNumbers(Set.of(1, 2, 3, 4, 5, 43));
        lottos = new Lottos(List.of(lottoNumbers1, lottoNumbers2));
    }

    @Test
    void returnCost() {
        assertThat(lottos.cost()).isEqualTo(2000);
    }
}
