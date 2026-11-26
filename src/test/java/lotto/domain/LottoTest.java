package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("로또 객체는 1~45 사이의 숫자로 만들 수 있다. (1, 45 → 성공)")
    @Test
    public void test_1() {
        assertThatNoException().isThrownBy(() -> new Lotto(1, 2, 3, 4, 5, 45));
    }

    @DisplayName("로또 객체는 1~45 외의 숫자를 가질 수 없다. (0, 46 → 실패)")
    @Test
    public void test_2() {
        assertThatThrownBy(() -> new Lotto(0, 2, 3, 4, 5, 6))
                .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> new Lotto(1, 2, 3, 4, 5, 46))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("로또 객체는 6개만 가질 수 있다. (5개 → 실패, 7개 → 실패)")
    @Test
    public void test_3() {
        assertThatThrownBy(() -> new Lotto(1, 2, 3, 4, 5))
                .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> new Lotto(1, 2, 3, 4, 5, 6, 7))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("로또 객체는 중복된 수를 가질 수 없다. (1, 1, 2, 3, 4, 5 → 실패)")
    @Test
    public void test_4() {
        assertThatThrownBy(() -> new Lotto(1, 1, 2, 3, 4, 5))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("당첨 로또와의 일치 개수를 알 수 있다. ([1,2,3,4,5,6] vs [1,2,3,7,8,9] → 3)")
    @Test
    public void test_5() {
        Lotto myLotto = new Lotto(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = new Lotto(1, 2, 3, 7, 8, 9);

        assertThat(myLotto.matchCount(winningLotto)).isEqualTo(3);
    }

    @DisplayName("당첨 로또가 내 로또의 등수를 알려준다. ([1,2,3,4,5,6] vs [1,2,3,7,8,9] → 3개 일치)")
    @Test
    public void test_6() {
        Lotto winningLotto = new Lotto(1, 2, 3, 4, 5, 6);
        Lotto myLotto = new Lotto(1, 2, 3, 7, 8, 9);

        assertThat(winningLotto.rank(myLotto)).isEqualTo(Prize.THREE);
    }
}
