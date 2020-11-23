package step2;

import org.junit.jupiter.api.Test;
import step2.domain.Lotto;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 구매갯수계산() {
        Lotto lotto = new Lotto(14000);
        assertThat(lotto.getCount()).isEqualTo(14);
    }
}
