package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {

    @DisplayName("6개의 숫자를 가진 로또를 생성한다")
    @Test
    void createLottoWithSixBall() {
        List<Number> numbers = IntStream.rangeClosed(1, 6).mapToObj(Number::of).collect(toList());
        Lotto lotto = Lotto.from(numbers);
        assertThat(lotto).isNotNull();
    }

    @DisplayName("로또 넘버가 6개가 아닌 경우 exception")
    @Test
    void createLottoByLessOrMoreNumberThenFail() {
        List<Number> numbers = IntStream.rangeClosed(1, 7).mapToObj(Number::of).collect(toList());
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lotto.from(numbers))
                .withMessageMatching("6개의 로또번호를 입력해주세요.");
    }

    @DisplayName("로또 넘버가 중복인 경우 exception")
    @Test
    void duplicatedLottoNumber() {
        List<Number> numbers = IntStream.of(1, 2, 3, 4, 5, 5).mapToObj(Number::of).collect(toList());
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lotto.from(numbers))
                .withMessageMatching("6개의 로또번호를 입력해주세요.");
    }
}
