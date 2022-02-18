package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName(value = "로또가 생성될 때, 로또 하나에는 6개의 숫자가 들어간다.")
    @Test
    void checkValidSize() {
        Lotto lotto = new Lotto(new HashSet(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(lotto.getLotto().size()).isEqualTo(6);
    }

    @DisplayName(value = "로또 번호가 6개가 아니면 IllegalArgumentException이 발생한다.")
    @Test
    void checkValidRange() {
        assertThatThrownBy(() -> new Lotto(new HashSet(Arrays.asList(1, 2, 3, 4, 5)))).isInstanceOf(
            IllegalArgumentException.class);
    }

}
