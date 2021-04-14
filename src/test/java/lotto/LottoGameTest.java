package lotto;

import lotto.exception.LottoNumbersSizeException;
import lotto.exception.MoneyNotEnoughException;
import lotto.exception.NumberAlreadyExistsException;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.model.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGameTest {


    @ParameterizedTest
    @ValueSource(ints = {9000, 1000, 25000, 4000})
    @DisplayName("buy lotto test by money : success")
    void buyLottoTest(int moneyAmount) {
        Money money = new Money(moneyAmount);
        LottoGame lottoGame = new LottoGame();
        lottoGame.buyLotto(money);
        assertThat(lottoGame.getLottos().size()).isEqualTo(money.amount() / 1000);
    }

    @ParameterizedTest
    @ValueSource(ints = {900, 100, 250, 10, 400})
    @DisplayName("buy lotto test by money : fail - not enough money")
    void buyLottoFailNotEnoughMoneyTest(int moneyAmount) {
        LottoGame lottoGame = new LottoGame();
        Money money = new Money(moneyAmount);
        assertThatThrownBy(() -> lottoGame.buyLotto(money))
                .isInstanceOf(MoneyNotEnoughException.class)
                .hasMessage("Money is not enough to buy lotto");
    }


    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6", "11, 22, 25, 45, 1, 3"})
    @DisplayName("input(make) last winning lotto test : success")
    void lastWinningLottoTest(String numbers) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.lastWinningLotto(new Lotto(numbers));
        String[] testNumbers = numbers.replace(" ", "").split(Lotto.DELIMITER);
        for (String testNumber : testNumbers) {
            assertThat(lottoGame.getWinLotto().getNumbers()).contains(new Number(Integer.parseInt(testNumber)));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 3, 5, 6", "11, 22, 25, 45, 11, 3"})
    @DisplayName("input(make) last winning lotto test : fail - duplicate nubmer")
    void lastWinningLottoFailDuplicateNumberTest(String numbers) {
        LottoGame lottoGame = new LottoGame();
        assertThatThrownBy(() -> lottoGame.lastWinningLotto(new Lotto(numbers)))
                .isInstanceOf(NumberAlreadyExistsException.class)
                .hasMessage("Number already exists.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 5, 6,45", "11, 22, 25, 45, 14, 3,2"})
    @DisplayName("input(make) last winning lotto test : fail - wrong nubmer counts")
    void lastWinningLottoFailWrongCountsNumbersTest(String numbers) {
        LottoGame lottoGame = new LottoGame();
        assertThatThrownBy(() -> lottoGame.lastWinningLotto(new Lotto(numbers)))
                .isInstanceOf(LottoNumbersSizeException.class)
                .hasMessage("Please input 6 numbers which last won game.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1, 2, 3, 3, 5, 6", "11, 22, 25, 46, 11, 3"})
    @DisplayName("input(make) last winning lotto test : fail - wrong range number")
    void lastWinningLottoFailWrongRangeNumberTest(String numbers) {
        LottoGame lottoGame = new LottoGame();
        assertThatThrownBy(() -> lottoGame.lastWinningLotto(new Lotto(numbers)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("input value in 1~45");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6", "11, 22, 25, 45, 1, 3"})
    @DisplayName("input(make) last winning lotto test : fail - contain BonusNumber")
    void lastWinningLottoFailContainBonusNumberTest(String numbers) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.setBonusNumber(new Number(1));
        assertThatThrownBy(() -> lottoGame.lastWinningLotto(new Lotto(numbers)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("winning number can't contain bonus number");
    }
}