package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoCashPrizeTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1, 0, 0, 0, 1, 0, 1:2000050000",
            "3, 0, 0, 0, 0, 0, 0:0",
            "2, 1, 0, 1, 0, 0, 0:5000"},
            delimiter = ':')
    public void 전체_상금_계산 (String result, int expected) {
        List<Integer> matchResult = Arrays.stream(result.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Assertions.assertThat(LottoCashPrize.calculateTotalPrize(matchResult))
                .isEqualTo(expected);
    }
}
