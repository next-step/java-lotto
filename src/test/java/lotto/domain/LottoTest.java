package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    @Test
    @DisplayName("숫자로 입력받은 로또는 해당 값들을 가지고 있습니다.")
    void containNumbersTest(){
        List<Integer> numbers = List.of(1, 2, 3, 4, 5,6);
        Lotto lotto = Lotto.valueOf(numbers);
        List<Integer> lottoNumbers = lotto.getNumbers();
        assertThat(numbers).allMatch(lottoNumbers::contains);
    }

    @Test
    @DisplayName("로또 숫자 갯수와 다른 수의 숫자 리스트로 로또를 만들려고 하면 IllegalArgumentException을 띄웁니다")
    void numbersCardinalityTest() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.valueOf(numbers));
    }

    @Test
    @DisplayName("같은 숫자들로 만들어진 로또는 equals true입니다.")
    void equalsTest() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto1 = Lotto.valueOf(numbers);
        Lotto lotto2 = Lotto.valueOf(numbers);
        assertThat(lotto1).isEqualTo(lotto2);
    }

    @Test
    @DisplayName("같은 숫자들로 만들어진 로또는 hashCode가 같습니다.")
    void hashCodeTest() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto1 = Lotto.valueOf(numbers);
        Lotto lotto2 = Lotto.valueOf(numbers);
        assertThat(lotto1.hashCode()).isEqualTo(lotto2.hashCode());
    }
}
