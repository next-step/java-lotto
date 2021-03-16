package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    Lotto lotto;

    @Test
    void makeLottoNumbers() {
        assertThat(lotto.makeLottoNumbers(14).size()).isEqualTo(14);
    }

    @BeforeEach
    void init() {
        lotto = new Lotto();
    }
}
