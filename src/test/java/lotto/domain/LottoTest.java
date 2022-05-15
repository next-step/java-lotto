package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("수동 Lotto 생성 확인")
    void createByHand() {
        Lotto lotto = new Lotto(new int[]{1, 5, 13, 24, 35, 45});
        assertThat(lotto).isEqualTo(new Lotto(new int[]{1, 5, 13, 24, 35, 45}));
    }

    @Test
    @DisplayName("로또 번호 확인")
    void hasNumbers() {
        Lotto lotto = new Lotto(new int[]{1, 5, 13, 24, 35, 45});
        assertThat(lotto.hasNumbers(LottoNumber.of(1))).isTrue();
    }

}