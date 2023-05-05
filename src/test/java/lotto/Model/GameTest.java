package lotto.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    @Test
    @DisplayName("game 시 ticket 개수 일치")
    public void game_count() {
        int expected = 14;

        Game game = new Game(expected);
        int actual = game.allTickets().size();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("addTicket 정상 확인")
    public void addTicket_count() {
        List<Integer> inputNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        TicketNumber inputTicketNumber = new TicketNumber(inputNumber);
        Ticket inputTicket = new Ticket(inputTicketNumber);

        List<Ticket> expected = List.of(inputTicket);

        Game game = new Game(0);
        game.addTicket(inputTicket);
        List<Ticket> actual = game.allTickets();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("6개 일치 확인")
    public void winner_count_6() {
        ArrayList<ArrayList<Integer>> inputNumbers = new ArrayList<>();
        inputNumbers.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        inputNumbers.add(new ArrayList<>(Arrays.asList(11, 12, 13, 14, 15, 16)));
        inputNumbers.add(new ArrayList<>(Arrays.asList(21, 22, 23, 24, 25, 26)));
        inputNumbers.add(new ArrayList<>(Arrays.asList(31, 33, 33, 34, 35, 36)));
        inputNumbers.add(new ArrayList<>(Arrays.asList(41, 42, 43, 44, 45, 40)));
        inputNumbers.add(new ArrayList<>(Arrays.asList(5, 6, 7, 8, 9, 10)));

        Game game = new Game(0);
        for (ArrayList<Integer> inputNumber : inputNumbers) {
            TicketNumber inputTicketNumber = new TicketNumber(inputNumber);
            Ticket inputTicket = new Ticket(inputTicketNumber);
            game.addTicket(inputTicket);
        }

        List<Integer> inputWinningNumber = Arrays.asList(5, 6, 7, 8, 9, 10);
        int inputBonusNumber = 11;

        HashMap<Integer, Integer> expected = new HashMap<>() {{
                put(3, 0);
                put(4, 0);
                put(5, 0);
                put(15, 0);
                put(6, 1);
        }};

        GameResult actual = game.calculateResult(inputWinningNumber, inputBonusNumber);

        assertThat(actual.table()).isEqualTo(expected);
    }

    @Test
    @DisplayName("5개 일치 확인")
    public void winner_count_5() {
        ArrayList<ArrayList<Integer>> inputNumbers = new ArrayList<>();
        inputNumbers.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        inputNumbers.add(new ArrayList<>(Arrays.asList(11, 12, 13, 14, 15, 16)));
        inputNumbers.add(new ArrayList<>(Arrays.asList(21, 22, 23, 24, 25, 26)));
        inputNumbers.add(new ArrayList<>(Arrays.asList(31, 33, 33, 34, 35, 36)));
        inputNumbers.add(new ArrayList<>(Arrays.asList(41, 42, 43, 44, 45, 40)));
        inputNumbers.add(new ArrayList<>(Arrays.asList(5, 6, 7, 8, 9, 10)));

        Game game = new Game(0);
        for (ArrayList<Integer> inputNumber : inputNumbers) {
            TicketNumber inputTicketNumber = new TicketNumber(inputNumber);
            Ticket inputTicket = new Ticket(inputTicketNumber);
            game.addTicket(inputTicket);
        }

        List<Integer> inputWinningNumber = Arrays.asList(5, 6, 7, 8, 9, 15);
        int inputBonusNumber = 11;

        HashMap<Integer, Integer> expected = new HashMap<>() {{
            put(3, 0);
            put(4, 0);
            put(5, 1);
            put(15, 0);
            put(6, 0);
        }};

        GameResult actual = game.calculateResult(inputWinningNumber, inputBonusNumber);

        assertThat(actual.table()).isEqualTo(expected);
    }

    @Test
    @DisplayName("4개 일치 확인")
    public void winner_count_4() {
        ArrayList<ArrayList<Integer>> inputNumbers = new ArrayList<>();
        inputNumbers.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        inputNumbers.add(new ArrayList<>(Arrays.asList(11, 12, 13, 14, 15, 16)));
        inputNumbers.add(new ArrayList<>(Arrays.asList(21, 22, 23, 24, 25, 26)));
        inputNumbers.add(new ArrayList<>(Arrays.asList(31, 33, 33, 34, 35, 36)));
        inputNumbers.add(new ArrayList<>(Arrays.asList(41, 42, 43, 44, 45, 40)));
        inputNumbers.add(new ArrayList<>(Arrays.asList(5, 6, 7, 8, 9, 10)));

        Game game = new Game(0);
        for (ArrayList<Integer> inputNumber : inputNumbers) {
            TicketNumber inputTicketNumber = new TicketNumber(inputNumber);
            Ticket inputTicket = new Ticket(inputTicketNumber);
            game.addTicket(inputTicket);
        }

        List<Integer> inputWinningNumber = Arrays.asList(5, 6, 7, 8, 15, 17);
        int inputBonusNumber = 11;

        HashMap<Integer, Integer> expected = new HashMap<>() {{
            put(3, 0);
            put(4, 1);
            put(5, 0);
            put(15, 0);
            put(6, 0);
        }};

        GameResult actual = game.calculateResult(inputWinningNumber, inputBonusNumber);

        assertThat(actual.table()).isEqualTo(expected);
    }

    @Test
    @DisplayName("3개 일치 확인")
    public void winner_count_3() {
        ArrayList<ArrayList<Integer>> inputNumbers = new ArrayList<>();
        inputNumbers.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        inputNumbers.add(new ArrayList<>(Arrays.asList(11, 12, 13, 14, 15, 16)));
        inputNumbers.add(new ArrayList<>(Arrays.asList(21, 22, 23, 24, 25, 26)));
        inputNumbers.add(new ArrayList<>(Arrays.asList(31, 33, 33, 34, 35, 36)));
        inputNumbers.add(new ArrayList<>(Arrays.asList(41, 42, 43, 44, 45, 40)));
        inputNumbers.add(new ArrayList<>(Arrays.asList(5, 6, 7, 8, 9, 10)));

        Game game = new Game(0);
        for (ArrayList<Integer> inputNumber : inputNumbers) {
            TicketNumber inputTicketNumber = new TicketNumber(inputNumber);
            Ticket inputTicket = new Ticket(inputTicketNumber);
            game.addTicket(inputTicket);
        }

        List<Integer> inputWinningNumber = Arrays.asList(5, 6, 7, 14, 15, 17);
        int inputBonusNumber = 11;

        HashMap<Integer, Integer> expected = new HashMap<>() {{
            put(3, 1);
            put(4, 0);
            put(5, 0);
            put(15, 0);
            put(6, 0);
        }};

        GameResult actual = game.calculateResult(inputWinningNumber, inputBonusNumber);

        assertThat(actual.table()).isEqualTo(expected);
    }

    @Test
    @DisplayName("5개+보너스번호 일치 확인")
    public void winner_count_5_with_bonus() {
        ArrayList<ArrayList<Integer>> inputNumbers = new ArrayList<>();
        inputNumbers.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        inputNumbers.add(new ArrayList<>(Arrays.asList(11, 12, 13, 14, 15, 16)));
        inputNumbers.add(new ArrayList<>(Arrays.asList(21, 22, 23, 24, 25, 26)));
        inputNumbers.add(new ArrayList<>(Arrays.asList(31, 33, 33, 34, 35, 36)));
        inputNumbers.add(new ArrayList<>(Arrays.asList(41, 42, 43, 44, 45, 40)));
        inputNumbers.add(new ArrayList<>(Arrays.asList(5, 6, 7, 8, 9, 10)));

        Game game = new Game(0);
        for (ArrayList<Integer> inputNumber : inputNumbers) {
            TicketNumber inputTicketNumber = new TicketNumber(inputNumber);
            Ticket inputTicket = new Ticket(inputTicketNumber);
            game.addTicket(inputTicket);
        }

        List<Integer> inputWinningNumber = Arrays.asList(5, 6, 7, 8, 9, 11);
        int inputBonusNumber = 10;

        HashMap<Integer, Integer> expected = new HashMap<>() {{
            put(3, 0);
            put(4, 0);
            put(5, 0);
            put(15, 1);
            put(6, 0);
        }};

        GameResult actual = game.calculateResult(inputWinningNumber, inputBonusNumber);

        assertThat(actual.table()).isEqualTo(expected);
    }
}