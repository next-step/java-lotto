package humbledude.lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @Test
    public void outOfBounds() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(0));
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(46));
    }
}
