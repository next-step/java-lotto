package lotto.Domain;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTest {

    @Test
    void lottoTest() {
        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(1);
        lottoNumbers.add(6);
        lottoNumbers.add(3);
        lottoNumbers.add(2);
        lottoNumbers.add(5);
        lottoNumbers.add(4);

        Lotto lotto = Lotto.init(lottoNumbers);

        assertThat(lotto).isEqualTo(Lotto.init(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 2 3 4 5", "1 2 3 4 5 6 7"})
    void lottoNumberCountExceptionTest(String input) {
        List<Integer> lottoNumbers = Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            Lotto.init(lottoNumbers);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"1 2 3 4 5 6:2", "13 24 1 5 42 7:4", "1 2 13 35 24 42:6"}, delimiter = ':')
    void matchLottoTest(String input, String expected) {
        List<Integer> lottoNumbers = Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        Lotto lotto = Lotto.init(lottoNumbers);
        List<Integer> winningNumber = new ArrayList<>(Arrays.asList(1, 2, 13, 24, 35, 42));
        int result = lotto.match(winningNumber);

        assertThat(result).isEqualTo(Integer.parseInt(expected));
    }
}
