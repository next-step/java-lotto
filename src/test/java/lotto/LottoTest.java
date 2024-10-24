package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoTest {

    @Test
    public void 로또_번호는_1에서45사이의_숫자이다() {
        List<Integer> numbers = List.of(1, 4, 45, 3, 6, 10);

        assertThatCode(() -> new Lotto(numbers)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource("provideInvalidLottoNumbers")
    public void 로또_번호가_1에서_45사이_숫자_외의_값일_경우_예외가_발생한다(List<Integer> numbers) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(numbers));
    }

    @Test
    public void 로또_번호가_6자리가_아닌_경우_예외가_발생한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(List.of(5, 4, 3, 2, 1)));
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(List.of(7, 6, 5, 4, 3, 2, 1)));
    }

    @Test
    public void 로또_번호가_중복_되면_예외가_발생한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(List.of(6, 5, 5, 3, 2, 1)));
    }

    @Test
    public void 로또_문자로_생성() {
        Lotto lotto = Lotto.from("1,2,3,4,5,6");
        assertThat(lotto).isEqualTo(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @Test
    public void 숫자아닌_문자로_생성되면_예외가_발생한다() {
       assertThatIllegalArgumentException().isThrownBy(()->Lotto.from("1,2,a,4,5,6"));
    }

    static Stream<Arguments> provideInvalidLottoNumbers() {
        return Stream.of(
                arguments(List.of(0, 1, 2, 3, 4, 5)),
                arguments(List.of(46, 1, 2, 3, 4, 5))
        );
    }
}
