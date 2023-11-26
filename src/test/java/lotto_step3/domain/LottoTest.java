package lotto_step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class LottoTest {

    @DisplayName("6개의 중복되지 않은 숫자 객체를 전달하면 lotto 객체를 생성한다.")
    @Test
    void lottoTest() {
        Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto).isInstanceOf(Lotto.class);
    }

    @DisplayName("빈 객체나 6개 이상의 숫자 객체를 전달하면 IllegalArgumentException을 던진다.")
    @Test
    void lottoExceptionTest() {
        assertThatThrownBy(() -> new Lotto(new HashSet<>()))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(Set.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("리스트 형태의 숫자를 전달하면 새로운 로또 객체를 생성한다.")
    @Test
    void listCreateTest() {
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto).isInstanceOf(Lotto.class);
    }

    @DisplayName("문자열 형태의 숫자를 전달하면 새로운 로또 객체를 생성한다.")
    @Test
    void stringCreateTest() {
        Lotto lotto = Lotto.from("1, 2, 3, 4, 5, 6");

        assertThat(lotto).isInstanceOf(Lotto.class);
    }

    @DisplayName("두 로또 객체를 비교해 일치하는 숫자의 개수를 반환한다.")
    @Test
    void matchCountTest() {
        Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        Lotto otherLotto = new Lotto(Set.of(1, 3, 5, 7, 9, 11));

        assertThat(lotto.matchCount(otherLotto)).isEqualTo(3);
    }
}