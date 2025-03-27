package step3.domain;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void 같은_숫자_갯수() {
        Lotto lotto1 = Lotto.of(1,2,3,4,5,6);
        Lotto lotto2 = Lotto.of(1,2,3,4,5,7);

        assertThat(lotto1.getMatchCount(lotto2)).isEqualTo(5);
    }
}
