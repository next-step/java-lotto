package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    @DisplayName("로또는 1~45의 값만 허용 확인")
    void create() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,58));
            Lotto lotto2 = new Lotto(Arrays.asList(-1,2,3,4,5,58));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("같은값을 입력했을경우 예외처리")
    void validation() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,5));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호도 있는지 확인")
    void existNumber() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        LottoNumber bonusNumber = new LottoNumber(11);

        assertThat(lotto.existNumber(bonusNumber)).isFalse();

        bonusNumber = new LottoNumber(6);

        assertThat(lotto.existNumber(bonusNumber)).isTrue();
    }

}