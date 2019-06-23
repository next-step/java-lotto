package lotto.model;

import lotto.exception.InvalidCountOfLottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTest {

    @DisplayName("6개의 숫자를 가진 로또를 생성한다")
    @Test
    void createLottoWithSixBall() {
        Lotto lotto = Lotto.from(ofNumbersByRange(1, 6));
        assertThat(lotto).isNotNull();
    }

    @DisplayName("로또 넘버가 6개가 아닌 경우 exception")
    @Test
    void createLottoByLessOrMoreNumberThenFail() {
        assertThatExceptionOfType(InvalidCountOfLottoException.class)
                .isThrownBy(() -> Lotto.from(ofNumbersByRange(1, 7)));
    }

    @DisplayName("로또 넘버가 중복인 경우 exception")
    @Test
    void duplicatedLottoNumber() {
        assertThatExceptionOfType(InvalidCountOfLottoException.class)
                .isThrownBy(() -> Lotto.from(ofNumbers(1, 2, 3, 4, 5, 5)));
    }

    private List<Number> ofNumbers(int... numbers) {
        return IntStream.of(numbers)
                .mapToObj(Number::of)
                .collect(toList());
    }

    private List<Number> ofNumbersByRange(int start, int end) {
        return IntStream
                .rangeClosed(start, end)
                .mapToObj(Number::of)
                .collect(toList());
    }
}