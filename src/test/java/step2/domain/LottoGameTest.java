package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.view.OutputView;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoGameTest {

    // init with null, emtpy
    @DisplayName("init Class")
    @ParameterizedTest
    @NullAndEmptySource
    public void testClassInitialize(String input) {

        LottoGame lottoGame = new LottoGame();

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Money money = new Money(input);
                    lottoGame.getGameCountByPayMoney(money);
                })
                .withMessage("Found a Illegal Argument(s).");
    }

    // init with 1000 ~
    @DisplayName("init Class")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1000", "2000", "5000", "10000"})
    public void testClassWithNormalInput(String input) {

        Money money = new Money(input);

        LottoGame lottoGame = new LottoGame();
        int gameCount = lottoGame.getGameCountByPayMoney(money);

        // lottoList = LottoGame.
        lottoGame.issueLotto(gameCount);

        //OutputView.
        OutputView.outputLottoList(lottoGame.getLottoList());
    }

    @DisplayName("init Class with negative input")
    @ParameterizedTest
    @ValueSource(strings = {"-1000", "-1"})
    public void testClassWithNormalInputWithError(String input) {

        LottoGame lottoGame = new LottoGame();

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->
                        {
                            Money money = new Money(input);
                            lottoGame.getGameCountByPayMoney(money);
                        }
                )
                .withMessage("Found a Illegal Argument(s).");
    }


    @DisplayName("test get Game Count length error")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    public void testCheckWiningNumber(String input) {

        LottoGame lottoGame = new LottoGame();

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> lottoGame.checkWiningNumber(input));
    }


    @DisplayName("init Class with negative input")
    @ParameterizedTest
    @ValueSource(strings = {"-1000", "-1"})
    public void testGetGameCountByPayMoneyWithError(String input) {

        Money money = new Money(input);
        LottoGame lottoGame = new LottoGame();

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> lottoGame.getGameCountByPayMoney(money))
                .withMessage("Found a Illegal Argument(s).");
    }


}
