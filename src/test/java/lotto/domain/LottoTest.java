package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LottoTest {
    @Test
    @DisplayName("6개의 1~45 숫자가 정상적으로 저장되는지 테스트")
    void getNumberTest() {
        Lotto lotto = new Lotto(8, 21, 23, 41, 42, 43);
        assertThat(lotto.getNumbers()).containsExactlyInAnyOrder(8, 21, 23, 41, 42, 43);
    }

    @Test
    @DisplayName("1~45 숫자가 외의 숫자가 입력시 Exception 발생하는지 테스트")
    void invalidNumberTest() {
        assertThatThrownBy(() -> new Lotto(0, 1, 2, 3, 4, 5)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 로또와 뽑은 로또간 비교를 한다.")
    void compareSameNumberCount() {
        Lotto lotto = new Lotto(8, 21, 23, 41, 42, 43);
        Lotto winnerLotto = new Lotto(8, 21, 23, 41, 42, 43);
        assertThat(lotto.sameNumberCount(winnerLotto)).isEqualTo(6);

        lotto = new Lotto(8, 21, 23, 41, 42, 43);
        winnerLotto = new Lotto(8, 21, 23, 41, 42, 44);
        assertThat(lotto.sameNumberCount(winnerLotto)).isEqualTo(5);

        lotto = new Lotto(8, 21, 23, 41, 42, 43);
        winnerLotto = new Lotto(8, 21, 23, 40, 42, 44);
        assertThat(lotto.sameNumberCount(winnerLotto)).isEqualTo(4);

        lotto = new Lotto(8, 21, 23, 41, 42, 43);
        winnerLotto = new Lotto(1, 21, 23, 40, 42, 44);
        assertThat(lotto.sameNumberCount(winnerLotto)).isEqualTo(3);

        lotto = new Lotto(1, 2, 3, 4, 5, 6);
        winnerLotto = new Lotto(7, 21, 23, 40, 42, 44);
        assertThat(lotto.sameNumberCount(winnerLotto)).isEqualTo(0);
    }
}