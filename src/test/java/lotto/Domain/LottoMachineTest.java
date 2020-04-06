package lotto.Domain;


import org.junit.jupiter.api.BeforeEach;
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

    @Test
    void boughtManualLottoTest() {
        List<String> manualLotto = new ArrayList<>(Arrays.asList("1, 2, 3, 4, 5, 6"
                , "2, 3, 4, 5, 6, 7"
                , "3, 4, 5, 6, 7, 8"));
        Lottos lottos = lottoMachine.purchaseManualLotto(manualLotto);

        assertThat(lottos.toList()).hasSize(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"14000:14", "1000:1", "3000:3"}, delimiter = ':')
    void boughtAutoLottoTest(String input, String expected) {
        int lottoCount = lottoMachine.boughtLottoCount(Integer.parseInt(input));
        Lottos lottos = lottoMachine.purchaseAutoLotto(lottoCount);
        assertThat(lottos.toList()).hasSize(Integer.parseInt(expected));
    }

    @Test
    void makeAutoTargetNumberTest() {
        Lottos lottos = lottoMachine.purchaseAutoLotto(1);

        lottos.toList().stream().forEach(lotto -> {
            assertThat(lotto.toList()).hasSize(6);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 2 13 4 5 6", "13 24 1 5 42 7", "1 2 13 35 24 42"})
    void makeLottoLottoTest(String input) {
        ArrayList<Integer> targetNumbers = Arrays.stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
        Lotto lotto = lottoMachine.buyLotto(targetNumbers);

        assertThat(lotto.toList()).isEqualTo(targetNumbers);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 2 13 4 5 6:5", "13 24 1 5 42 7:50", "1 2 13 35 24 42:2000000"}, delimiter = ':')
    void buyLottoTest(String input, String expected) {
        ArrayList<Integer> targetNumbers = Arrays.stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
        Lotto lotto = lottoMachine.buyLotto(targetNumbers);
        Lottos lottos = Lottos.init(new ArrayList<>());
        lottos.add(lotto);

        int bonus = 7;
        Lotto winLotto = Lotto.init(new ArrayList<>(Arrays.asList(1, 2, 13, 24, 35, 42)));
        WinningLotto winningNumber = WinningLotto.init(winLotto, bonus);

        LottoResult statistics = lottos.match(winningNumber);
        Double revenueRate = statistics.revenueRate();

        assertThat(revenueRate).isEqualTo(Double.parseDouble(expected));
    }
}
