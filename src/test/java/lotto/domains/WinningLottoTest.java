package lotto.domains;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    @Test
    void 생성자_테스트() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(), 1);
        assertThat(winningLotto).isNotNull();
    }

    @Test
    void 당첨번호에_보너스번호가_포함되어있을경우_에러_테스트() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6", 1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
