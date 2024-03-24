package domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoTest {


    @DisplayName("IntegerList를 이용하여 로또를 생성할 수 있다.")
    @Test
    void create() {
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(lotto).isEqualTo(Lotto.from(List.of(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("번호내에 중복이 있을 경우 예외를 던진다.")
    @Test
    void createWithDuplicateNumber() {
        Assertions.assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 3, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("번호내에 중복이 있을 경우 예외를 던진다.")
    @Test
    void createWithNullList() {
        Assertions.assertThatThrownBy(() -> Lotto.from(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 갯수가 로또 숫자 갯수보다 많을 때 ")
    @Test
    void createWithOutNumberList() {
        Assertions.assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("일치하는 로또 번호 갯수를 반환한다.")
    @Test
    void contains() {
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(lotto.countOfMatch(Lotto.from(List.of(1, 2, 3, 19,20,21)))).isEqualTo(3);
    }
}
