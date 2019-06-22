package step2.iksoo.lottoAuto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private final int LOTTO_SIZE = 6;

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto();
    }

    @Test
    void 숫자_여섯개() {
        assertThat(lotto.isNumSize(LOTTO_SIZE)).isTrue();
    }
}
