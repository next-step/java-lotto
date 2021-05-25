package lotto.controllers;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.Lotto;
import lotto.Model;
import lotto.domains.BonusNumber;
import lotto.domains.Ticket;
import lotto.exceptions.DuplicateNumbersException;

public class WinningNumbersControllerTest {

    private Model model = new Model();
    private Lotto lotto = new Lotto(model);

    private WinningNumbersController winningNumbersController;

    @BeforeEach
    void setUp() {
        winningNumbersController = new WinningNumbersController(lotto);
    }

    @DisplayName("당첨 번호 및 보너스 번호 입력 성공")
    @ParameterizedTest(name = "당첨번호: \"{0}\", 보너스: \"{1}\", 출력: \"{2}\"")
    @CsvSource(value = {
        "1,2,3,4,5,6:7:[1, 2, 3, 4, 5, 6] + 7",
        "45,44,43,42,41,40:39:[40, 41, 42, 43, 44, 45] + 39"}, delimiter = ':')
    void saveWinningNumbers(String ticket, String number, String expected) {
        Ticket winningTicket = new Ticket(ticket);
        BonusNumber bonusNumber = new BonusNumber(number);

        winningNumbersController.saveWinningNumbers(winningTicket, bonusNumber);

        assertThat(lotto.storage().loadWinningNumbers().toString()).isEqualTo(expected);
    }

    @DisplayName("중복된 숫자를 입력하여 보너스 번호 입력을 실패한다.")
    @ParameterizedTest(name = "[1, 2, 3, 4, 5, 6]: \"{0}\"")
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
    void createBonusNumber_DuplicateNumber_ExceptionThrown(String input) {
        Ticket winningTicket = new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(input);

        assertThatExceptionOfType(DuplicateNumbersException.class).isThrownBy(() -> {
            winningNumbersController.saveWinningNumbers(winningTicket, bonusNumber);
        });
    }
}
