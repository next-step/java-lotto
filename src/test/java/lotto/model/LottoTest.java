package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    @Test
    @DisplayName("Lotto 당첨 번호가 몇 개인지 정확히 반환한다.")
    void getMatchCountTest() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = new Lotto(4, 5, 6, 7, 8, 9);
        assertThat(lotto.countMatchNumbers(winningLotto)).isEqualTo(3);
    }

    @Test
    @DisplayName("Lotto 객체는 1과 45 사이 외의 숫자나 6개 이상의 숫자를 가지면 에러를 반환한다.")
    void invalidLottoTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(0, 2, 3, 4, 5, 6));
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(1, 2, 3, 4, 5, 46));
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)));
    }
}