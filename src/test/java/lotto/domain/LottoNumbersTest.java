package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumbersTest {
    @Test
    @DisplayName("숫자로 입력받은 값들을 가지고 있습니다.")
    void containNumbersTest() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        LottoNumbers lottoNumbers = LottoNumbers.valueOf(numbers);
        assertThat(numbers).allMatch(lottoNumbers.value()::contains);
    }

    @Test
    @DisplayName("로또 숫자 갯수와 다른 수의 숫자 리스트로 로또를 만들려고 하면 IllegalArgumentException을 띄웁니다")
    void numbersCardinalityTest() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumbers.valueOf(numbers));
    }

    @Test
    @DisplayName("중복 숫자를 포함한 숫자 리스트로 로또를 만들려고 하면 IllegalArgumentException을 띄웁니다")
    void duplicatedNumberTest() {
        List<Integer> numbers = List.of(1, 2, 2, 3, 4, 5);
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumbers.valueOf(numbers));
    }

    @Test
    @DisplayName("로또 최대 숫자보다 큰 숫자 리스트로 로또를 만들려고 하면 IllegalArgumentException을 띄웁니다")
    void numberIsOutOfRangeTest() {
        List<Integer> numbers = List.of(1, 2, 2, 3, 4, 500);
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumbers.valueOf(numbers));
    }

    @Test
    @DisplayName("같은 lottoNum으로 만들어지면 equals true입니다.")
    void equalsTest() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        LottoNumbers lotto1 = LottoNumbers.valueOf(numbers);
        LottoNumbers lotto2 = LottoNumbers.valueOf(numbers);
        assertThat(lotto1).isEqualTo(lotto2);
    }


    @Test
    @DisplayName("같은 lottoNum으로 만들어지면 hashCode가 같습니다.")
    void hashCodeTest() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        LottoNumbers lotto1 = LottoNumbers.valueOf(numbers);
        LottoNumbers lotto2 = LottoNumbers.valueOf(numbers);
        assertThat(lotto1.hashCode()).isEqualTo(lotto2.hashCode());
    }
}
