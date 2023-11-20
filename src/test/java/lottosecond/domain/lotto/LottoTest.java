package lottosecond.domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    @DisplayName("입력받은 로또와 자신의 로또 번호 중 몇개가 겹치는지 반환해줍니다.")
    void matchNumberCount() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        // when
        int result = lotto.matchNumberCount(winningLotto);
        // then
        Assertions.assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("겹치는 번호가 하나도 없으면 0을 반환합니다.")
    void noMatchNumber() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(11, 12, 13, 14, 17, 18));
        // when
        int result = lotto.matchNumberCount(winningLotto);
        // then
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("번호의 개수가 6개가 아니면 에러를 발생시킵니다.")
    void notSixNumber() {
        // given
        // when
        // then
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 반드시 6개여야 합니다. 입력받은 로또 번호 개수는 9개 입니다.");
    }

    @DisplayName("중복된 번호를 포함해서 6개가 입력되어도 에러를 발생시킵니다.")
    @Test
    void duplicateError() {
        // given
        // when
        // then
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 반드시 6개여야 합니다. 입력받은 로또 번호 개수는 5개 입니다.");
    }
}