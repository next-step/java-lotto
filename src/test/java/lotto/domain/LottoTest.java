package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @DisplayName("로또 생성 후 로또가 생성되었는지 확인")
    @Test
    void createLotto() {
        Lotto lotto = new Lotto();
        assertThat(lotto.isCreate()).isTrue();
    }

}
