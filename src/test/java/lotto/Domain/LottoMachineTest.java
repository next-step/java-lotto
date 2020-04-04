package lotto.Domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoMachineTest {

    LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = LottoMachine.init();
    }

    @ParameterizedTest
    @CsvSource(value = {"14000:14", "1000:1", "3000:3"}, delimiter = ':')
    void boughtLottoCountTest(String input, String expected) {
        int lottoCount = lottoMachine.boughtLottoCount(Integer.parseInt(input));

        assertThat(lottoCount).isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 500})
    void boughtLottoCountTest(int input) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            lottoMachine.boughtLottoCount(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 2 13 4 5 6", "13 24 1 5 42 7", "1 2 13 35 24 42"})
    void makeLottoLottoTest(String input) {
        ArrayList<Integer> targetNumbers = Arrays.stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
        Lotto lotto = lottoMachine.makeLotto(targetNumbers);

        assertThat(lotto.toList()).isEqualTo(targetNumbers);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 2 13 4 5 6:5", "13 24 1 5 42 7:50", "1 2 13 35 24 42:2000000"}, delimiter = ':')
    void buyLottoTest(String input, String expected) {
        ArrayList<Integer> targetNumbers = Arrays.stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
        Lottos lottos = lottoMachine.buyLotto(Lotto.init(targetNumbers));

        List<Integer> winningNumber = new ArrayList<>(Arrays.asList(1, 2, 13, 24, 35, 42));
        Map<Integer, Integer> statistics = lottos.match(winningNumber);
        Double revenueRate = lottos.revenueRate(statistics);

        assertThat(revenueRate).isEqualTo(Double.parseDouble(expected));
    }
}
