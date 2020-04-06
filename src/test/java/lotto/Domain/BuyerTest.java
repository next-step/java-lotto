package lotto.Domain;


import lotto.Buyer;
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

public class BuyerTest {

    private Buyer buyer;

    @BeforeEach
    void setUp() {
        buyer = Buyer.of();
    }

    @ParameterizedTest
    @CsvSource(value = {"14000:14", "1000:1", "3000:3"}, delimiter = ':')
    void payToLottoTest(String input, String expected) {
        int lottoCount = buyer.payToLotto(Integer.parseInt(input));

        assertThat(lottoCount).isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @ValueSource(ints = {14, 3, 1})
    void buyAutoLottoTest(int input) {
        Lottos lottos = buyer.purchaseAutoLotto(input);

        assertThat(lottos.toList()).hasSize(input);
    }

    @Test
    void winningLottoTest() {
        List<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonus = 7;

        WinningLotto winningLotto = buyer.winningLottoNumbers(lottoNumbers, bonus);

        WinningLotto resultWinningLotto = WinningLotto.init(Lotto.init(lottoNumbers), bonus);
        assertThat(winningLotto).isEqualTo(resultWinningLotto);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 2 13 4 5 6:5", "13 24 1 5 42 7:50", "1 2 13 35 24 42:2000000"}, delimiter = ':')
    void lottoResultTest(String input, String expected) {
        List<Integer> lottoNumbers = Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        int bonus = 7;

        Lottos lottos = Lottos.init(lottoNumbers);
        WinningLotto winningLotto = buyer.winningLottoNumbers(lottoNumbers, bonus);
        LottoResult lottoResult = buyer.lottoResult(lottos, winningLotto);

        assertThat(lottoResult.revenueRate()).isEqualTo(Double.parseDouble(expected));
    }
}
