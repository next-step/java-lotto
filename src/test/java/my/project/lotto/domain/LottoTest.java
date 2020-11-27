package my.project.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created : 2020-11-27 오전 9:55
 * Developer : Seo
 */
class LottoTest {

    @DisplayName("6개의 번호여야 한다.")
    @Test
    void shouldHaveParamSixDigit_OtherwiseThrowException() {
        List<Integer> lotto = Arrays.asList(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> new Lotto(lotto))
                .hasMessage("로또 한 장은 6개 번호입니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 번호가 있어선 안된다.")
    @Test
    void shouldNotBeDuplicated() {
        List<Integer> lotto = Arrays.asList(1, 2, 3, 4, 5, 5);
        assertThatThrownBy(() -> new Lotto(lotto))
                .hasMessage("로또 한 장은 6개 번호입니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("번호는 0보다 크고")
    @Test
    void shouldBeGreaterThanZero() {
        List<Integer> lotto = Arrays.asList(1, 2, 3, 4, 5, 0);
        assertThatThrownBy(() -> new Lotto(lotto))
                .hasMessage("로또 번호는 1과 45 사이입니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("번호는 46보다 작다")
    @Test
    void shouldBeLessThan46() {
        List<Integer> lotto = Arrays.asList(1, 2, 3, 4, 5, 47);
        assertThatThrownBy(() -> new Lotto(lotto))
                .hasMessage("로또 번호는 1과 45 사이입니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testConstructor() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto).isNotNull();
    }

    @Test
    void testMatch() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.match(winningLotto)).isEqualTo(Rank.FIRST);
    }

    @Test
    void testContains() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.contains(1)).isTrue();
    }

    @Test
    void testToString() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.toString())
                .isEqualTo("[ 1, 2, 3, 4, 5, 6 ]");
    }
}