package step4.iksoo.lottoManual;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNoTest {
    @Test
    void _1부터_45를_벗어나면_예외발생() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNo(0);
            new LottoNo(46);
        });
    }
}
