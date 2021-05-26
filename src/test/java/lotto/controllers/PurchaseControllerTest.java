package lotto.controllers;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.Lotto;
import lotto.Model;
import lotto.exceptions.CashOutOfBoundsException;
import lotto.exceptions.InvalidNumberException;

public class PurchaseControllerTest {

    private Model model = new Model();
    private Lotto lotto = new Lotto(model);

    private PurchaseController purchaseController;

    @BeforeEach
    void setUp() {
        this.purchaseController = new PurchaseController(lotto);
    }

    @DisplayName("로또 구입 성공")
    @ParameterizedTest(name = "금액: \"{0}\", 티켓 수: \"{1}\"")
    @CsvSource(value = {"1000,1", "12345,12"})
    void buyTickets(String input, int expected) {
        purchaseController.buyTickets(input);

        assertThat(lotto.storage().loadPurchase().ticketsAmount()).isEqualTo(expected);
    }

    @DisplayName("숫자가 아닌 문자열은 티켓 구매를 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "a"})
    void buyTickets_InvalidNumber_ExceptionThrown(String input) {
        assertThatExceptionOfType(InvalidNumberException.class).isThrownBy(() -> {
            purchaseController.buyTickets(input);
        });
    }

    @DisplayName("구입 가능 범위를 벗어나 티켓 구매를 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"999", "1000001"})
    void buyTickets_NumberOutOfBounds_ExceptionThrown(String input) {
        assertThatExceptionOfType(CashOutOfBoundsException.class).isThrownBy(() -> {
            purchaseController.buyTickets(input);
        });
    }

}
