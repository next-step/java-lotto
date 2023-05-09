package lotto.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    private final ArrayList<ArrayList<Integer>> inputNumbers = new ArrayList<>();
    private Game game;
    private HashMap<Integer, Integer> expected;

    @BeforeEach
    public void setUp() {
        inputNumbers.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        inputNumbers.add(new ArrayList<>(Arrays.asList(11, 12, 13, 14, 15, 16)));
        inputNumbers.add(new ArrayList<>(Arrays.asList(21, 22, 23, 24, 25, 26)));
        inputNumbers.add(new ArrayList<>(Arrays.asList(31, 33, 33, 34, 35, 36)));
        inputNumbers.add(new ArrayList<>(Arrays.asList(41, 42, 43, 44, 45, 40)));
        inputNumbers.add(new ArrayList<>(Arrays.asList(5, 6, 7, 8, 9, 10)));

        List<Ticket> inputTiketsForCountMatchedNumber = new ArrayList<>();
        for (ArrayList<Integer> inputNumber : inputNumbers) {
            TicketNumber inputTicketNumber = new TicketNumber(inputNumber);
            inputTiketsForCountMatchedNumber.add(new Ticket(inputTicketNumber));
        }
        game = new Game(inputTiketsForCountMatchedNumber.size(), inputTiketsForCountMatchedNumber);

        expected = new HashMap<>() {{
            put(3, 0);
            put(4, 0);
            put(5, 0);
            put(15, 0);
            put(6, 0);
        }};
    }

    @Test
    @DisplayName("addTicket 정상 확인")
    public void addTicket_count() {
        List<Integer> inputNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        TicketNumber inputTicketNumber = new TicketNumber(inputNumber);
        Ticket inputTicket = new Ticket(inputTicketNumber);

        List<Ticket> expected = List.of(inputTicket);

        Game gameForAddTicket = new Game(0);
        gameForAddTicket.addTicket(inputTicket);
        List<Ticket> actual = gameForAddTicket.allTickets();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("6개 일치 확인")
    public void winner_count_6() {
        List<Integer> inputWinningNumber = Arrays.asList(5, 6, 7, 8, 9, 10);
        int inputBonusNumber = 11;

        expected.put(6, 1);

        GameResult actual = game.calculateResult(inputWinningNumber, inputBonusNumber);

        assertThat(actual.table()).isEqualTo(expected);
    }

    @Test
    @DisplayName("5개 일치 확인")
    public void winner_count_5() {
        List<Integer> inputWinningNumber = Arrays.asList(5, 6, 7, 8, 9, 15);
        int inputBonusNumber = 11;

        expected.put(5, 1);

        GameResult actual = game.calculateResult(inputWinningNumber, inputBonusNumber);

        assertThat(actual.table()).isEqualTo(expected);
    }

    @Test
    @DisplayName("4개 일치 확인")
    public void winner_count_4() {
        List<Integer> inputWinningNumber = Arrays.asList(5, 6, 7, 8, 15, 17);
        int inputBonusNumber = 11;

        expected.put(4, 1);

        GameResult actual = game.calculateResult(inputWinningNumber, inputBonusNumber);

        assertThat(actual.table()).isEqualTo(expected);
    }

    @Test
    @DisplayName("3개 일치 확인")
    public void winner_count_3() {
        List<Integer> inputWinningNumber = Arrays.asList(5, 6, 7, 14, 15, 17);
        int inputBonusNumber = 11;

        expected.put(3, 1);

        GameResult actual = game.calculateResult(inputWinningNumber, inputBonusNumber);

        assertThat(actual.table()).isEqualTo(expected);
    }

    @Test
    @DisplayName("5개+보너스번호 일치 확인")
    public void winner_count_5_with_bonus() {
        List<Integer> inputWinningNumber = Arrays.asList(5, 6, 7, 8, 9, 11);
        int inputBonusNumber = 10;

        expected.put(15, 1);

        GameResult actual = game.calculateResult(inputWinningNumber, inputBonusNumber);

        assertThat(actual.table()).isEqualTo(expected);
    }
}