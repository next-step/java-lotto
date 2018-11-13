package domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {
    @Test
    public void 로또번호와_당첨번호를_비교한다() {
        List<LottoNumber> numbers = Stream.of(1, 2, 3, 4, 5, 6)
            .map(LottoNumber::new)
            .collect(Collectors.toList());

        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 7, 8), new LottoNumber(9));

        LottoNumbers lottoNumbers = new LottoNumbers(numbers);
        int matched = lottoNumbers.match(winningNumber);

        assertThat(matched).isEqualTo(4);
    }

    @Test
    public void 로또번호와_보너스번호를_비교한다() {
        List<LottoNumber> numbers = Stream.of(1, 2, 3, 4, 5, 9)
            .map(LottoNumber::new)
            .collect(Collectors.toList());

        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 7, 8), new LottoNumber(9));

        LottoNumbers lottoNumbers = new LottoNumbers(numbers);
        boolean matched = lottoNumbers.matchBonus(winningNumber);

        assertThat(matched).isEqualTo(true);
    }
}