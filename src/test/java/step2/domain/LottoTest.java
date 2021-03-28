package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.constants.Constants;
import step2.generator.TestLottoNumberGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTest {

    @Test
    @DisplayName("번호가 6개인 로또가 생성된다")
    void from() {
        Lotto lotto = Lotto.from(new TestLottoNumberGenerator());
        assertThat(lotto.getNumbers().size()).isEqualTo(Constants.LOTTO_SIZE);
    }

    @Test
    @DisplayName("생성된 로또번호는 오름차순으로 정렬되어있다")
    void sort() {
        Lotto lotto = Lotto.from(new TestLottoNumberGenerator());
        assertAll(
            () -> assertThat(lotto.getNumbers().get(0)).isEqualTo(Number.from(1)),
            () -> assertThat(lotto.getNumbers().get(1)).isEqualTo(Number.from(2)),
            () -> assertThat(lotto.getNumbers().get(2)).isEqualTo(Number.from(3)),
            () -> assertThat(lotto.getNumbers().get(3)).isEqualTo(Number.from(4)),
            () -> assertThat(lotto.getNumbers().get(4)).isEqualTo(Number.from(5)),
            () -> assertThat(lotto.getNumbers().get(5)).isEqualTo(Number.from(6))
        );
    }

    @Test
    @DisplayName("로또를 6개 번호로 생성하지 않으면 RuntimeException 발생한다")
    void from_isNotLottoSize() {
        List<Number> numbers = Arrays.asList(1, 2, 3, 4, 5).stream()
                .map(i -> Number.from(i))
                .collect(Collectors.toList());

        assertThatThrownBy(() -> Lotto.from(numbers))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("당첨번호와 모두 일치한다")
    void getMatchCount_allMatch() {
        // given
        Lotto lotto = Lotto.from(new TestLottoNumberGenerator());
        Lotto prizeLotto = Lotto.from(new TestLottoNumberGenerator());

        // when
        int matchCount = lotto.getMatchCount(prizeLotto);

        // then
        assertThat(matchCount).isEqualTo(6);
    }

    @Test
    @DisplayName("당첨번호와 5개와 일치한다")
    void getMatchCount_fiveMatch() {
        // given
        Lotto lotto = Lotto.from(new TestLottoNumberGenerator());
        List<Number> numbers = Arrays.asList(1, 2, 3, 4, 5, 45).stream()
                .map(i -> Number.from(i))
                .collect(Collectors.toList());
        Lotto prizeLotto = Lotto.from(numbers);

        // when
        int matchCount = lotto.getMatchCount(prizeLotto);

        // then
        assertThat(matchCount).isEqualTo(5);
    }

    @Test
    @DisplayName("당첨번호와 4개와 일치한다")
    void getMatchCount_fourMatch() {
        // given
        Lotto lotto = Lotto.from(new TestLottoNumberGenerator());
        List<Number> numbers = Arrays.asList(1, 2, 3, 4, 44, 45).stream()
                .map(i -> Number.from(i))
                .collect(Collectors.toList());
        Lotto prizeLotto = Lotto.from(numbers);

        // when
        int matchCount = lotto.getMatchCount(prizeLotto);

        // then
        assertThat(matchCount).isEqualTo(4);
    }

    @Test
    @DisplayName("당첨번호와 3개와 일치한다")
    void getMatchCount_threeMatch() {
        // given
        Lotto lotto = Lotto.from(new TestLottoNumberGenerator());
        List<Number> numbers = Arrays.asList(1, 2, 3, 43, 44, 45).stream()
                .map(i -> Number.from(i))
                .collect(Collectors.toList());
        Lotto prizeLotto = Lotto.from(numbers);

        // when
        int matchCount = lotto.getMatchCount(prizeLotto);

        // then
        assertThat(matchCount).isEqualTo(3);
    }
}
