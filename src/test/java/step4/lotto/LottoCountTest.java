package step4.lotto;

import org.junit.jupiter.api.Test;
import step4.lotto.domain.Count;
import step4.lotto.domain.LottoCount;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoCountTest {

    @Test
    void init() {
        LottoCount lottoCount = new LottoCount();
        assertThat(lottoCount).isEqualTo(new LottoCount());
    }

    @Test
    void 수동갯수가_로또_총_갯수보다_큼() {
        LottoCount lottoCount = new LottoCount(3_000,5);
        assertThatThrownBy(() -> {
            Count manualCount = lottoCount.autoCount();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
