package lotto.domains;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.enums.Prize;
import lotto.exceptions.DuplicateNumbersException;

public class WinningNumbersTest {

    private List<Ticket> tickets = Arrays.asList(
        new Ticket("40,41,42,43,44,45"), // ZERO
        new Ticket("1,41,42,43,44,45"), // ONE
        new Ticket("1,2,42,43,44,45"), // TWO
        new Ticket("1,2,3,43,44,45"), // THREE
        new Ticket("1,2,3,5,44,45"), // FOUR
        new Ticket("1,2,3,5,13,45"), // FIVE
        new Ticket("1,2,3,5,8,13"), // SIX
        new Ticket("1,2,3,5,8,21") // BONUS
    );
    private Ticket winningTicket = new Ticket("1,2,3,5,8,13");
    private BonusNumber bonusNumber = new BonusNumber("21");
    WinningNumbers winningNumbers = new WinningNumbers(winningTicket, bonusNumber);

    @DisplayName("보너스 번호가 중복이면 생성 실패")
    @ParameterizedTest(name = "[1, 2, 3, 5, 8, 13]: \"{0}\"")
    @ValueSource(strings = {"1", "2", "3", "5", "8", "13"})
    void createWinningNumber_DuplicateBonusNumber_ExceptionThrown(String input) {
        BonusNumber bonusNumber = new BonusNumber(input);
        assertThatExceptionOfType(DuplicateNumbersException.class).isThrownBy(() -> {
            new WinningNumbers(winningTicket, bonusNumber);
        });
    }

    private static Stream<Arguments> classifyPrize() {
        return Stream.of(
            Arguments.of(0, Prize.ZERO),
            Arguments.of(1, Prize.ONE),
            Arguments.of(2, Prize.TWO),
            Arguments.of(3, Prize.THREE),
            Arguments.of(4, Prize.FOUR),
            Arguments.of(5, Prize.FIVE),
            Arguments.of(6, Prize.SIX),
            Arguments.of(7, Prize.BONUS)
        );
    }

    @DisplayName("로또 번호의 당첨 결과 반환")
    @ParameterizedTest
    @MethodSource
    void classifyPrize(int index, Prize expected) {
        assertThat(winningNumbers.classifyPrize(tickets.get(index))).isEqualByComparingTo(expected);
    }
}
