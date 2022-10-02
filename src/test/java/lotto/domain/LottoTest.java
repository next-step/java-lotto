package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    void create() {
        Lotto lotto = new Lotto(() -> List.of(3, 10, 5, 20, 43, 31));
        assertThat(lotto).isEqualTo(new Lotto(List.of(3,10,5,20,43,31)));
    }

    @DisplayName("두 장의 로또에서 매칭된 숫자 개수를 반환한다")
    @Test
    void matchedCount() {
        Lotto lotto1 = new Lotto(() -> List.of(3, 10, 5, 20, 43, 31));
        Lotto lotto2 = new Lotto(() -> List.of(3, 10, 5, 20, 1, 2));

        assertThat(lotto1.matchedCount(lotto2)).isEqualTo(4);
    }

    @DisplayName("리턴된 numbers 를 수정하면 예외가 발생한다.")
    @Test
    void numbers() {
        Lotto lotto = new Lotto(() -> List.of(3, 10, 5, 20, 43, 31));
        List<Integer> numbers = lotto.numbers();

        assertThatThrownBy(() -> numbers.set(0, 1)).isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() -> numbers.add(45)).isInstanceOf(UnsupportedOperationException.class);
    }
}