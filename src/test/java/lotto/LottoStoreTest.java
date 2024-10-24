package lotto;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class LottoStoreTest {

    @Test
    public void 로또는_천원단위가_아니면_예외가_발생한다() {
        LottoStore lottoStore = new LottoStore();
        assertThatIllegalArgumentException().isThrownBy(() -> lottoStore.buy(999));
    }
}
