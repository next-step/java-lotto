package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("로또는 6개의 번호를 갖는다.")
    @Test
    void lottoNumber() {
        Lotto lotto = new Lotto();
        assertThat(lotto.getNumbers()).hasSize(6);
    }

    @DisplayName("로또의 번호는 1~45의 범위를 갖는다.")
    @Test
    void lottoNumberRange() {
        Lotto lotto = new Lotto();
        assertThat(lotto.getNumbers()).allSatisfy(number -> {
            assertThat(number).isBetween(1, 45);
        });
    }

    @DisplayName("로또의 번호가 1~45 범위가 아니라면 IllegalArgumentException 예외를 발생시킨다.")
    @Test
    void lottoNumberOutOfRange() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);
        assertThatThrownBy(() -> new Lotto(numbers))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Lotto는 다른 Lotto와 일치하는 번호의 개수를 확인할 수 있다.")
    @Test
    void checkNumber() {
        List<Integer> number1 = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> number2 = List.of(4, 5, 6, 7, 8, 9);

        Lotto lotto1 = new Lotto(number1);
        Lotto lotto2 = new Lotto(number2);

        assertThat(lotto1.countMatchWith(lotto2)).isEqualTo(3);
    }
}
