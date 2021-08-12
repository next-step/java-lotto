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

class LottoTest {

    private static final boolean CREATE_STATE = true;
    private static final boolean SORTED_STATE = true;
    private static final String DELIMITER = ",";

    @DisplayName("로또 생성 후 로또가 생성되었는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "2,3,4,5,6,7", "4,5,6,7,8,9"})
    void createLotto(String numbers) {
        List<Number> numbersList = getNumbers(numbers);
        Lotto lotto = new Lotto(numbersList);
        assertThat(lotto.isCreate()).isEqualTo(CREATE_STATE);
    }

    @DisplayName("로또 번호가 정렬되어있는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"6,5,4,3,2,1", "7,6,5,4,3,2"})
    void isSortedLotto(String numbers) {
        List<Number> numbersList = getNumbers(numbers);
        Lotto lotto = new Lotto(numbersList);
        assertThat(lotto.isSorted()).isEqualTo(SORTED_STATE);
    }

    @DisplayName("당첨 번호와 일치 여부 확인")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6", "2,3,4,5,6,7:5", "4,5,6,7,8,9:3"}, delimiter = ':')
    void isWin(String numbers, int expectedMatchCount) {
        List<Number> numberList = getNumbers(numbers);
        Lotto lotto = new Lotto(numberList);
        assertThat(lotto.match(getWinnerNumbers())).isEqualTo(expectedMatchCount);
    }

    private List<Number> getNumbers(String numbers) {
        return Stream.of(numbers.split(DELIMITER))
                .map(Integer::parseInt)
                .map(Number::new)
                .collect(Collectors.toList());
    }

    private List<Number> getWinnerNumbers() {
        return Arrays.asList(
                new Number(1),
                new Number(2),
                new Number(3),
                new Number(4),
                new Number(5),
                new Number(6));
    }


}
