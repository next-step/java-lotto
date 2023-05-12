package lotto.domain;

import lotto.domain.exception.InvalidLottoSizeException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoTest {
    @Test
    void Set으로_로또_객체를_만들_수_있다() {
        Set<LottoNumber> numbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
        assertThat(new Lotto(numbers).getLottoNumberSet().containsAll(numbers)).isTrue();
    }

    @Test
    void String으로_로또_객체를_만들_수_있다() {
        String numbers = "1, 2, 3, 4, 5, 6";
        Set<LottoNumber> numberSet = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
        assertThat(Lotto.from(numbers).getLottoNumberSet().containsAll(numberSet)).isTrue();
    }

    @ParameterizedTest(name = "{0}을 가지고 있는지에 대한 결과는 {1}이다.")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:true", "5:true", "6:true", "7:false"}, delimiter = ':')
    void 특정_숫자를_갖고_있는지_확인할_수_있다(int number, boolean expected) {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        assertThat(Lotto.from(numbers).hasNumber(new LottoNumber(number))).isEqualTo(expected);
    }

    @Test
    void 로또_숫자의_개수가_6개가_아니면_오류가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(Set.of()))
                .isInstanceOf(InvalidLottoSizeException.class);
    }

    @Test
    void 로또에_중복된_숫자가_있으면_오류가_발생한다() {
        assertThatThrownBy(() -> Lotto.from("1, 2, 3, 4, 5, 5"))
                .isInstanceOf(InvalidLottoSizeException.class);
    }

    @Test
    void 갖고_있는_수가_동일하면_동일한_로또_객체이다() {
        Lotto lotto1 = Lotto.from("1, 2, 3, 4, 5, 6");
        Lotto lotto2 = Lotto.from("1, 2, 3, 4, 5, 6");
        assertThat(lotto1).isEqualTo(lotto2);
    }
}
