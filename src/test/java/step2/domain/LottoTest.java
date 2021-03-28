package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.constants.Constants;
import step2.generator.TestLottoNumberGenerator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    @DisplayName("번호가 6개인 로또가 생성된다")
    void from() {
        Lotto lotto = Lotto.from(new TestLottoNumberGenerator());
        assertThat(lotto.getNumbers().size()).isEqualTo(Constants.LOTTO_SIZE);
    }

    @Test
    @DisplayName("로또를 6개 번호로 생성하지 않으면 RuntimeException 발생한다")
    void from_isNotLottoSize() {
        Set<Number> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5))
                .stream()
                .map(i -> Number.from(i))
                .collect(Collectors.toSet());

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
        Set<Number> numbers = new HashSet<>(Arrays.asList(purchaseNumber.split(",")))
                .stream()
                .map(i -> Number.from(Integer.valueOf(i)))
                .collect(Collectors.toSet());
        Lotto prizeLotto = Lotto.from(numbers);

        // when
        int matchCount = lotto.getMatchCount(prizeLotto);

        // then
        assertThat(matchCount).isEqualTo(expectedMatchCount);
    }
}
