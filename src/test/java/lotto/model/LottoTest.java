package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTest {

    @ParameterizedTest
    @DisplayName("일치하는 숫자 개수별 통계")
    @CsvSource(value = {
            "1, 2, 3, 4, 5, 6:1",
            "3, 4, 5, 6, 7, 8:4",
            "20, 21, 22, 23, 24, 25:6",
            "1, 2, 3, 4, 5, 7:2"},
            delimiter = ':')
    public void 티켓별_랭킹_확인 (String numbers, int expectedRank) {
        List<Integer> numberList = Arrays.stream(numbers.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Lotto ticket = new Lotto(numberList);

        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1,2,3,4,5,6), 7);

        Assertions.assertThat(winningNumber.match(ticket).rank())
                .isEqualTo(expectedRank);
    }
}
