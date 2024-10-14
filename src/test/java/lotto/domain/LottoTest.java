package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("로또가 잘 생성되는지")
    @Test
    void lottoTest() {
        Lotto lotto1 = new Lotto(1, 2, 3, 4, 5, 6);
        Lotto lotto2 = new Lotto("1, 2, 3, 4, 5, 6");
        assertThat(lotto1).isEqualTo(lotto2);
    }
}
