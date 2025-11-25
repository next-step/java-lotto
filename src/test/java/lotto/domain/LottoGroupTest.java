package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoGroupTest {
    @Test
    void 로또_몇장_구매할_수_있는지() {
        LottoGroup lottoGroup = new LottoGroup(14000);

        assertThat(lottoGroup.getLottoNumbers()).hasSize(14);
    }
}
