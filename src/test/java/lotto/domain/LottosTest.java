package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottosTest {

    @ParameterizedTest(name = "로또개수 확인. 구매금액={0}, 로또 수={1}")
    @CsvSource(value = {"14000,14", "3333, 3"})
    void getLottoCount(int purchaseAmount, int expectedLottoCount) {

        Lottos lottos = new Lottos(purchaseAmount);
        assertThat(lottos.getLottoCount()).isEqualTo(expectedLottoCount);
    }

    @ParameterizedTest(name = "구매금액이 0 이하일 경우 IllegalArgumentException 발생")
    @ValueSource(ints = {0, -1})
    void getLottosCountIsLowerEqualsThan0(int purchaseAmount) {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lottos(purchaseAmount));
    }

    @ParameterizedTest(name = "지난주 우승번호와 일차하는 개수 확인. 일치개수={0}")
    @ValueSource(ints = {3, 4, 5, 6})
    void getWonNumbersCorrectCount(int correctCount) {

        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 11, 12, 13)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 12, 13)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 13)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
        ));

        WonNumbers wonNumbers = new WonNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottos.getWonNumbersCorrectCount(correctCount, wonNumbers)).isEqualTo(1);
    }
}