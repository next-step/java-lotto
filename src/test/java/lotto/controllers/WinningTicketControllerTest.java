package lotto.controllers;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.Lotto;
import lotto.Model;
import lotto.domains.Purchase;
import lotto.domains.Ticket;
import lotto.domains.Tickets;
import lotto.exceptions.DuplicateNumbersException;
import lotto.exceptions.InsufficientNumbersException;
import lotto.exceptions.InvalidPatternException;
import lotto.exceptions.NumberOutOfBoundsException;

public class WinningTicketControllerTest {

    private Purchase purchase = new Purchase("12345");
    private List<Ticket> ticketList = Arrays.asList(
        new Ticket("1,2,3,4,5,6"),
        new Ticket("1,2,3,4,5,6"),
        new Ticket("1,2,3,4,5,11"),
        new Ticket("1,2,3,4,10,11")
    );
    private Tickets tickets = new Tickets(ticketList);
    private Ticket winningTicket = new Ticket("1,2,3,4,5,6");

    private Model model = new Model();
    private Lotto lotto = new Lotto(model);

    private WinningTicketController winningTicketController;

    @BeforeEach
    void setUp() {
        lotto.storage().savePurchase(purchase);
        lotto.storage().saveAutomatedTickets(tickets);
        lotto.storage().saveWinningTicket(winningTicket);

        winningTicketController = new WinningTicketController(lotto);
    }

    @DisplayName("당첨 번호 입력 성공")
    @ParameterizedTest(name = "입력: \"{0}\", 출력: \"{1}\"")
    @CsvSource(value = {
        "1,2,3,4,5,6:[1, 2, 3, 4, 5, 6]",
        "45,44,43,42,41,40:[40, 41, 42, 43, 44, 45]"
    }, delimiter = ':')
    void askWinningTicket(String input, String expected) {
        winningTicketController.saveWinningTicket(input);

        assertThat(lotto.storage().loadWinningTicket().toString()).isEqualTo(expected);
    }

    @DisplayName("잘못된 입력으로 당첨 번호 입력을 실패한다.")
    @ParameterizedTest(name = "입력: \"{0}\"")
    @ValueSource(strings = {"", "a"})
    void createTicket_InvalidPattern_ExceptionThrown(String input) {
        assertThatExceptionOfType(InvalidPatternException.class).isThrownBy(() -> {
            winningTicketController.saveWinningTicket(input);
        });
    }

    @DisplayName("숫자 6개가 아니면 당첨 번호 입력을 실패한다.")
    @ParameterizedTest(name = "입력: \"{0}\"")
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    void createTicket_Not6_ExceptionThrown(String input) {
        assertThatExceptionOfType(InsufficientNumbersException.class).isThrownBy(() -> {
            winningTicketController.saveWinningTicket(input);
        });
    }

    @DisplayName("1 ~ 45를 벗어난 숫자를 입력하여 티켓 생성을 실패한다.")
    @ParameterizedTest(name = "입력: \"{0}\"")
    @ValueSource(strings = {"0,1,2,3,4,5", "1,2,3,4,5,99"})
    void createTicket_NumberOutOfBounds_ExceptionThrown(String input) {
        assertThatExceptionOfType(NumberOutOfBoundsException.class).isThrownBy(() -> {
            winningTicketController.saveWinningTicket(input);
        });
    }

    @DisplayName("중복된 숫자를 입력하여 당첨 번호 입력을 실패한다.")
    @ParameterizedTest(name = "입력: \"{0}\"")
    @ValueSource(strings = {"1,2,2,3,4,5"})
    void createTicket_OutOfBoundNumber_ExceptionThrown(String input) {
        assertThatExceptionOfType(DuplicateNumbersException.class).isThrownBy(() -> {
            winningTicketController.saveWinningTicket(input);
        });
    }
}
