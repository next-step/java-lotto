package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {

    private static final String DELIMITER = ",";
    private static final int DEFAULT_NUMBER_SIZE = 6;

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "2,3,4,5,6,7", "4,5,6,7,8,9"})
    void size(String data) {
        Numbers numbers = new Numbers(getNumbers(data));
        assertThat(numbers.size()).isEqualTo(6);
    }

    @DisplayName("당첨 번호와 일치하는 갯수 확인")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6", "2,3,4,5,6,7:5", "4,5,6,7,8,9:3"}, delimiter = ':')
    void match(String data, int expectedMatchCount) {
        Numbers numbers = new Numbers(getWinnerNumbers());
        Numbers other = new Numbers(getNumbers(data));
        assertThat(numbers.match(other)).isEqualTo(expectedMatchCount);
    }

    @DisplayName("6개의 랜덤Number 생성 확인")
    @Test
    void createRandomNumbers() {
        assertThat(Numbers.createRandomNumbers().size()).isEqualTo(DEFAULT_NUMBER_SIZE);
    }

    private List<Number> getNumbers(String numbers) {
        return Stream.of(numbers.split(DELIMITER))
                .map(Integer::parseInt)
                .map(Number::new)
                .collect(Collectors.toList());
    }

    private List<Number> getWinnerNumbers() {
        int[] winnerNumbers = {1, 2, 3, 4, 5, 6};
        return Arrays.stream(winnerNumbers)
                .mapToObj(Number::new)
                .collect(Collectors.toList());
    }
}