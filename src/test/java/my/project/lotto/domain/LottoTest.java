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
    // TODO 인자에 대한 유효성 체크
    //@DisplayName("6개의 각 숫자는 1에서 45사이의 값이어야 한다.")

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

    @DisplayName("생성")
    @Test
    void paramShouldHaveSixDigit() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto).isNotNull();
    }

    @DisplayName("번호 비교")
    @Test
    void match() {
        Lotto userLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(userLotto.match(winningLotto)).isEqualTo(6);
    }

    @Test
    void draw() {

    }
}