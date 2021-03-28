package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
        List<Number> numbers = Arrays.asList(1, 2, 3, 4, 5)
                .stream()
                .map(i -> Number.from(i))
                .collect(Collectors.toList());

        assertThatThrownBy(() -> Lotto.from(numbers))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("당첨번호와 구매번호 일치 개수 확인")
    @ParameterizedTest
    @CsvSource(value = {"40,41,42,43,44,45:0", "1,41,42,43,44,45:1", "1,2,42,43,44,45:2", "1,2,3,43,44,45:3", "1,2,3,4,44,45:4",
            "1,2,3,4,5,45:5", "1,2,3,4,5,6:6"}, delimiter = ':')
    void getMatchCount(String purchaseNumber, int expectedMatchCount) {
        // given
        Lotto lotto = Lotto.from(new TestLottoNumberGenerator());
        List<Number> numbers = Arrays.asList(purchaseNumber.split(","))
                .stream()
                .map(i -> Number.from(Integer.valueOf(i)))
                .collect(Collectors.toList());
        Lotto prizeLotto = Lotto.from(numbers);

        // when
        int matchCount = lotto.getMatchCount(prizeLotto);

        // then
        assertThat(matchCount).isEqualTo(expectedMatchCount);
    }
}
