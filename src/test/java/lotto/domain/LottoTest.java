package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    @DisplayName("로또 생성")
    void create() {
        Lotto lotto = Lotto.from(1, 2, 3, 4, 5, 6);
        assertThat(lotto).isEqualTo(Lotto.from(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("로또의 숫자 갯수가 6개가 아니면 에러가 발생한다.")
    void validNumberSize() {
        assertThatThrownBy(() -> Lotto.from(1, 2, 3, 4, 5, 6, 7))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Lotto.from(1, 2, 3, 4, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또는 중복된 숫자가 포함되면 에러가 발생한다")
    void validDuplicatedNumber() {
        assertThatThrownBy(() -> Lotto.from(1, 2, 3, 4, 5, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
