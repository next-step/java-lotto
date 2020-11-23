package humbledude.lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinningNumbersTest {

    @ParameterizedTest
    @CsvSource(value = {"1;2;3;4;5;6,7,6", "1;2;3;4;5;45,7,5", "1;41;42;43;44;45,7,1"})
    public void getMatchedCount(String numbers, int bonus, int count) {
        Set<LottoNumber> testcaseNumbers = Stream.of(numbers.split(";"))
                .map(Integer::valueOf)
                .map(LottoNumber::of)
                .collect(Collectors.toSet());

        LottoWinningNumbers winningNumbers = new LottoWinningNumbers(
                new LottoNumberSet(TestHelper.setOf(1, 2, 3, 4, 5, 6)),
                LottoNumber.of(bonus));
        LottoNumberSet ticket = new LottoNumberSet(testcaseNumbers);

        assertThat(winningNumbers.getMatchedCountWith(ticket)).isEqualTo(count);
    }

    @Test
    public void validWinningNumbers() {
       assertThat(new LottoWinningNumbers(
               new LottoNumberSet(TestHelper.setOf(1, 2, 3, 4, 5, 6)),
               LottoNumber.of(7)
               ))
               .isInstanceOf(LottoWinningNumbers.class);
    }
}
