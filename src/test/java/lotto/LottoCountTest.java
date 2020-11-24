package lotto;

import lotto.model.LottoCount;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoCountTest {
    @Test
    public void 가진_금액_보다_구입_개수가_많은_경우() {
        assertThatIllegalArgumentException().isThrownBy(() ->  new LottoCount(14000, "15"));
    }

    @Test
    public void 정상_구입() {
        LottoCount lottoCount = new LottoCount(14000,"3");
        assertThat(lottoCount.getManualCount()).isEqualTo(3);
        assertThat(lottoCount.getAutoCount()).isEqualTo(11);
    }

}
