package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @ParameterizedTest
    @CsvSource(
            value = {
                    "1,2,3,4,5,6:6",
                    "2,3,4,5,6,7:5",
                    "3,4,5,6,7,8:4",
                    "4,5,6,7,8,9:3",
                    "5,6,7,8,9,10:2",
                    "6,7,8,9,10,11:1",
                    "7,8,9,10,11,12:0"
            },
            delimiter = ':'
    )
    void 갯수_매칭_테스트(String winningNumbers, int matches) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.confirmWinning(Arrays.stream(winningNumbers.split(",")).map(Integer::parseInt).collect(Collectors.toList()))).isEqualTo(matches);
    }
}