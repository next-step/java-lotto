package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    Lotto lotto;

    @Test
    void pay() {
        assertThat(lotto.pay(14000).size()).isEqualTo(14);
    }

    @BeforeEach
    void init() {
        lotto = new Lotto();
    }
}
