package lotto.domain;

import lotto.util.RandomUtil;
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

    @DisplayName("당첨 번호와 일치하는 갯수 확인")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6", "2,3,4,5,6,7:5", "4,5,6,7,8,9:3"}, delimiter = ':')
    void match(String data, int expectedMatchCount) {
        Numbers numbers = new Numbers(getWinnerNumbers());
        Numbers other = new Numbers(getNumbers(data));
        assertThat(numbers.match(other)).isEqualTo(expectedMatchCount);
    }

    @DisplayName("size만큼의 랜덤Number 생성 확인")
    @ParameterizedTest
    @ValueSource(ints = {6, 7, 9})
    void createRandomNumbers(int size) {
        Numbers numbers = Numbers.createNumbers(RandomUtil.getRandomInteger(size));
        assertThat(numbers.size()).isEqualTo(size);
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