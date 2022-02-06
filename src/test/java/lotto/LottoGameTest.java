package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import lotto.domain.money.Money;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGameTest {

    private static final int MINIMUM_MONEY = 1000;

    @ParameterizedTest
    @ValueSource(ints = {1000, 1999, 10000, 5000})
    void 구매가_가능한_경우의_금액에_따른_로또_개수(int money) {
        LottoGame lottoGame = new LottoGame();
        assertThat(money / 1000).isEqualTo(lottoGame.calculateLottoCount(new Money(money)));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 100, 999, 200})
    void 구매가_불가능한_경우(int money) {
        LottoGame lottoGame = new LottoGame();
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
            () -> lottoGame.calculateLottoCount(new Money(money))).withMessage(
            "[ERROR] " + MINIMUM_MONEY + "원에 1장입니다. " + MINIMUM_MONEY + "보다 큰 값을 입력해주세요.");
    }
}