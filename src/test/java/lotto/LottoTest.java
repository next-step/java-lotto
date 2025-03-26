package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoTest {

    @Test
    @DisplayName("로또는 생성될때 숫자 6자리를 입력 받아 생성된다.")
    void lottoCreateTest() {
        var lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Assertions.assertThat(lotto).isInstanceOf(Lotto.class);
    }

    @Test
    @DisplayName("로또는 6자리 보다 적거나 많은 숫자를 받을 수 없다.")
    void lottoCreateNumbersSizeTest2() {
        Assertions.assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또는 6자리여야 합니다.");

        Assertions.assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또는 6자리여야 합니다.");
    }
}
