package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BonusNumberTest {
    @Test
    public void equals() {
        assertThat(new LottoNumber(7).isEqual(new BonusNumber(7))).isTrue();
    }
}
