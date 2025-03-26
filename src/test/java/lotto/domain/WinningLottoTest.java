package lotto.domain;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {
    private final WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6));

    @ParameterizedTest
    @CsvSource({
        "1|2|3|4|5|6, FIRST",
        "1|2|3|4|5|7, SECOND",
        "1|2|3|4|7|8, THIRD",
        "1|2|3|7|8|9, FOURTH",
        "1|2|7|8|9|10, NO_PRIZE",
        "7|8|9|10|11|12, NO_PRIZE"
    })
    @DisplayName("로또 번호 일치 개수 검증")
    void countMatchingNumbers_다양한_케이스_검증(String numbers, PrizeLevel expectedLevel) {
        List<Integer> numberList = Arrays.stream(numbers.split("\\|"))
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        Lotto lotto = new Lotto(numberList);
        assertThat(winningLotto.countMatchingNumbers(lotto))
            .as("로또 번호: %s", numbers)
            .isEqualTo(expectedLevel);
    }
}
