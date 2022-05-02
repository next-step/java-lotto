package autolotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4 ,5, 6:3"}, delimiter = ':')
    void numberGiven_ReturnContainResult(String number, int compare) {
        Set<Integer> numbers = Arrays.stream(number.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        assertThat(new WinningLotto(new LottoNumbers(numbers)).contains(compare)).isTrue();
    }
}
