package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoStoreTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 15000})
    public void 로또는_천원단위로_생선된다(int fee) {
        LottoStore lottoStore = new LottoStore();

        List<Lotto> result = lottoStore.buy(fee);
        assertThat(result).hasSize(fee / 1000);
    }

    @Test
    public void 로또는_천원단위가_아니면_예외가_발생한다() {
        LottoStore lottoStore = new LottoStore();
        assertThatIllegalArgumentException().isThrownBy(() -> lottoStore.buy(999));
    }

    @Test
    public void 금액은_음수일경우_예외가_발생한다(){
        LottoStore lottoStore = new LottoStore();
        assertThatIllegalArgumentException().isThrownBy(()->lottoStore.buy(-1000));
    }
}
