package lotto.domain;

import lotto.domain.enums.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("당첨 로또와 보너스 숫자가 주어졌을 때 로또 등수를 구한다")
    @Test
    void rank() {
        Lotto lotto = new Lotto(List.of(3, 10, 5, 20, 43, 31));
        Lotto winningLotto = new Lotto(List.of(3, 10, 5, 20, 1, 2));
        Integer bonusNumber = 43;

        assertThat(lotto.rank(winningLotto, bonusNumber)).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("리턴된 numbers 를 수정하면 예외가 발생한다.")
    @Test
    void numbers() {
        List<Integer> numbers = new Lotto(List.of(3, 10, 5, 20, 43, 31)).numbers();

        assertThatThrownBy(() -> numbers.set(0, 1)).isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() -> numbers.add(45)).isInstanceOf(UnsupportedOperationException.class);
    }
}