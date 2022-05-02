package autolotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(new LottoNumbers(Set.of(1, 2, 3, 4, 5, 6)));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, 2, 3, 4 ,5, 6:6",
            "1, 2, 3, 4, 5, 43:5",
            "1, 2, 3, 4, 41, 42:4"
    }, delimiter = ':')
    void winningLottoGiven_ReturnMatchCount(String number, int matchCount) {
        Set<Integer> numbers = Arrays.stream(number.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        assertThat(lotto.match(new WinningLotto(new LottoNumbers(numbers)))).isEqualTo(matchCount);
    }
}
