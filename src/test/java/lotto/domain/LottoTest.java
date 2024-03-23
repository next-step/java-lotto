package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("매번 shuffle된 List가 생성된다")
    void shuffle_test() {
        Lotto lotto1 = new Lotto();
        Lotto lotto2 = new Lotto();

        assertThat(lotto1.getAutoLotto()).isNotEqualTo(lotto2.getAutoLotto());
    }

}
