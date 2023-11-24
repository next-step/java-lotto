package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottosTest {

    @Test
    @DisplayName("입력된 금액만큼 로또 발급")
    public void 금액에_따른_로또_발급_갯수() {
        Assertions.assertThat(Lottos.issue(5000).count())
                .isEqualTo(5);
    }

    @ParameterizedTest
    @DisplayName("일치하는 숫자 개수별 통계")
    @CsvSource(value = {
            "1, 2, 3, 4, 5, 6:1, 0, 0, 0, 1, 0, 1",
            "10, 11, 12, 13, 14, 15:3, 0, 0, 0, 0, 0, 0",
            "2, 9, 13, 27, 42, 15:2, 1, 0, 0, 0, 0, 0"},
            delimiter = ':')
    public void 일치하는_숫자_갯수 (String numbers, String expected) {
        Lottos tickets = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(1,2,3,4,5,6)),
                new Lotto(Arrays.asList(3,4,5,6,7,8)),
                new Lotto(Arrays.asList(20,21,22,23,24,25))
        ));

        List<Integer> numberList = Arrays.stream(numbers.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> expectedResult = Arrays.stream(expected.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Assertions.assertThat(tickets.matchNumbers(LottoNumbers.of(numberList)))
                .isEqualTo(expectedResult);
    }
}
