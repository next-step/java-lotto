package lotto.controllers;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.Lotto;
import lotto.Model;
import lotto.domains.Ticket;
import lotto.exceptions.DuplicateNumbersException;
import lotto.exceptions.InvalidNumberException;
import lotto.exceptions.NumberOutOfBoundsException;

public class BonusNumberControllerTest {

    private Model model = new Model();
    private Lotto lotto = new Lotto(model);
    private Ticket winningTicket = new Ticket("1,2,3,4,5,6");

    private BonusNumberController bonusNumberController;

    @BeforeEach
    void setUp() {
        lotto.storage().saveWinningTicket(winningTicket);

        bonusNumberController = new BonusNumberController(lotto);
    }

    @DisplayName("보너스 번호 입력 성공")
    @ParameterizedTest(name = "입력: \"{0}\"")
    @CsvSource(value = {"7", "8", "45"})
    void askBonusNumber(String input) {
        bonusNumberController.saveBonusNumber(input, winningTicket);
    }

    @DisplayName("잘못된 입력으로 보너스 번호 입력을 실패한다.")
    @ParameterizedTest(name = "입력: \"{0}\"")
    @ValueSource(strings = {"", "a"})
    void createBonusNumber_InvalidPattern_ExceptionThrown(String input) {
        assertThatExceptionOfType(InvalidNumberException.class).isThrownBy(() -> {
            bonusNumberController.saveBonusNumber(input, winningTicket);
        });
    }

    @DisplayName("1 ~ 45를 벗어난 숫자를 입력하여 보너스 번호 생성을 실패한다.")
    @ParameterizedTest(name = "입력: \"{0}\"")
    @ValueSource(strings = {"0", "99"})
    void createBonusNumber_NumberOutOfBounds_ExceptionThrown(String input) {
        assertThatExceptionOfType(NumberOutOfBoundsException.class).isThrownBy(() -> {
            bonusNumberController.saveBonusNumber(input, winningTicket);
        });
    }

    @DisplayName("중복된 숫자를 입력하여 보너스 번호 생성을 실패한다.")
    @ParameterizedTest(name = "[1, 2, 3, 4, 5, 6]: \"{0}\"")
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
    void createBonusNumber_DuplicateNumber_ExceptionThrown(String input) {
        assertThatExceptionOfType(DuplicateNumbersException.class).isThrownBy(() -> {
            bonusNumberController.saveBonusNumber(input, winningTicket);
        });
    }

}
