package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningLottoTest {

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {
            "1, 2, 3, 4, 5, 6       | FIRST",
            "1, 2, 3, 4, 10, 11     | THIRD",
            "1, 2, 10, 11, 12, 13   | MISS"
    })
    void 로또를_입력받아_등수를_반환한다(String lottoNumbers, Rank expected) {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        Lotto lotto = new Lotto(toNumbers(lottoNumbers));

        assertThat(winningLotto.match(lotto)).isEqualTo(expected);
    }

    private List<Integer> toNumbers(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }
}
