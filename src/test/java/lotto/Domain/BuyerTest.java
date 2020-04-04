package lotto.Domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class BuyerTest {

    LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = LottoMachine.init();
    }


    @ParameterizedTest
    @CsvSource(value = {"14000:14", "1000:1", "3000:3"}, delimiter = ':')
    void autoLottoTest(String input, String expected) {
        Buyer buyer = Buyer.of(Integer.parseInt(input));
        Lottos lottos = buyer.autoLotto();

        assertThat(lottos.toList()).hasSize(Integer.parseInt(expected));
    }
}
