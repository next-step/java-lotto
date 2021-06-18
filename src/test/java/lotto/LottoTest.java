package lotto;

import lotto.objects.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    public Lotto myLotto;

    @BeforeEach
    void setUp() {
        myLotto = new Lotto(new HashSet<>(Arrays.asList(3, 4, 5, 6, 7, 8)));
    }

    @ParameterizedTest
    @ValueSource(ints = {7})
    void addNumber(int number) {
        Lotto winngingLotto = new Lotto(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        winngingLotto.addNumber(number);
        assertThat(winngingLotto.getNumbers()).usingFieldByFieldElementComparator().isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    }

    @Test
    void getNumbers() {
        Lotto lotto = new Lotto(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(lotto.getNumbers()).usingFieldByFieldElementComparator().isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:4", "1,2,3,4,5,6,7:5"}, delimiter = ':')
    void countSameNumbers(String value1, String value2) {
        String[] numbers = value1.split(",");
        List<Integer> lottoNumbers = Arrays.stream(numbers).map(number -> Integer.parseInt(number)).collect(Collectors.toList());
        Lotto winningLotto = new Lotto(new HashSet<>(lottoNumbers));

        int expected = Integer.parseInt(value2);

        int matchCount = myLotto.countSameNumbers(winningLotto);

        assertThat(matchCount).isEqualTo(expected);
    }
}
