package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LottosTest {

    private Lottos lottos;

    @BeforeEach
    void setUp() {
        Lotto lotto1 = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(Arrays.asList(3,53,2,7,1,4));

        this.lottos = new Lottos(Arrays.asList(lotto1, lotto2));
    }

    @Test
    void getCount() {
        assertThat(lottos.getCount()).isEqualTo(2);
    }
}
