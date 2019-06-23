package lotto.model;

import lotto.exception.InvalidCountOfLottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static lotto.model.Lotto.SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTest {

    @DisplayName("로또번호가 6개 일치하는 경우")
    @Test
    void matchCountToOtherLotto() {
        Lotto lotto = ofLotto(1, 2, 3, 4, 5, 6);
        Lotto otherLotto = ofLotto(1, 2, 3, 4, 5, 6);
        int matchCount = lotto.getMatchCount(otherLotto);
        assertThat(matchCount).isEqualTo(6);
    }

    @DisplayName("6개의 숫자를 가진 로또를 생성한다")
    @Test
    void createLottoWithSixBall() {
        Lotto lotto = Lotto.from(ofNumbers(SIZE));
        assertThat(lotto).isNotNull();
    }

    @DisplayName("로또 넘버가 6개가 아닌 경우 exception")
    @ParameterizedTest
    @ValueSource(ints = {
            SIZE - 1,
            SIZE + 1,
    })
    void createLottoByLessOrMoreNumberThenFail(int numberCount) {
        assertThatExceptionOfType(InvalidCountOfLottoException.class)
                .isThrownBy(() -> Lotto.from(ofNumbers(numberCount)));
    }

    @DisplayName("로또 넘버가 중복인 경우 exception")
    @Test
    void duplicatedLottoNumber() {
        assertThatExceptionOfType(InvalidCountOfLottoException.class)
                .isThrownBy(() -> Lotto.from(ofNumbers(1, 2, 3, 4, 5, 5)));
    }

    static Lotto ofLotto(int... numbers) {
        return Lotto.from(ofNumbers(numbers));
    }

    static List<Number> ofNumbers(int... numbers) {
        return IntStream.of(numbers)
                .mapToObj(Number::of)
                .collect(toList());
    }

    private List<Number> ofNumbers(int count) {
        return IntStream
                .rangeClosed(1, count)
                .mapToObj(Number::of)
                .collect(toList());
    }
}