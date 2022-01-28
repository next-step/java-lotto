package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또는 6개의 숫자를 가지고 있다")
    @Test
    void 로또_길이_확인() {
        Lotto lotto = new Lotto();
        assertThat(lotto.getNumbers().size()).isEqualsTo(6);
    }
}