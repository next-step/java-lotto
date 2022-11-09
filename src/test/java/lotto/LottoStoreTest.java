package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {
    @Test
    void test_purchase() {
        LottoNumbers manual = LottoNumbers.of(1, 2, 3, 4, 5, 6);
        LottoNumbers auto = LottoNumbers.of(3, 4, 5, 6, 7, 8);

        Lotto lotto = LottoStore.purchase(2, 1, () -> manual, () -> auto);
        assertThat(lotto).isEqualTo(new Lotto(List.of(manual, manual, auto)));
    }
}
