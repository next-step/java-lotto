package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.exceptions.DuplicateNumbersException;
import lotto.exceptions.InvalidNumberException;
import lotto.exceptions.NumberOutOfBoundsException;

public class BonusNumberTest {

    Ticket winningTicket = new Ticket("1,2,3,4,5,6");

    @DisplayName("보너스 숫자가 티켓에 있는지 판별한다.")
    @ParameterizedTest(name = "[1, 2, 3, 4, 5, 6]: {0} - {1}")
    @CsvSource(value = {"1,true", "7,false"})
    void bonusNumber_IsExistInTicket(String input, boolean expected) {
        Ticket winningTicket = new Ticket(Arrays.asList(11, 12, 13, 14, 15, 16));
        BonusNumber bonusNumber = new BonusNumber(input, winningTicket);

        Ticket ticket = new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(bonusNumber.isExist(ticket)).isEqualTo(expected);
    }

    @DisplayName("빈 문자열 또는 null 값이면 에러 발생")
    @Test
    void bonusNumber_EmptyOrNull_ExceptionThrown() {
        assertThatExceptionOfType(InvalidNumberException.class).isThrownBy(() -> {
            new BonusNumber("", winningTicket);
        });
        assertThatExceptionOfType(InvalidNumberException.class).isThrownBy(() -> {
            new BonusNumber(null, winningTicket);
        });
    }

    @DisplayName("숫자 범위가 1 ~ 45 사이가 아니면 에러 발생")
    @ParameterizedTest(name = "{0}은 불가능")
    @ValueSource(strings = {"0", "46"})
    void bonusNumber_OutOfBounds_ExceptionThrown(String input) {
        assertThatExceptionOfType(NumberOutOfBoundsException.class).isThrownBy(() -> {
            new BonusNumber(input, winningTicket);
        });
    }

    @DisplayName("중복된 숫자를 입력하여 보너스 번호 생성을 실패한다.")
    @ParameterizedTest(name = "[1, 2, 3, 4, 5, 6]: \"{0}\"")
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
    void bonusNumber_DuplicateNumber_ExceptionThrown(String input) {
        assertThatExceptionOfType(DuplicateNumbersException.class).isThrownBy(() -> {
            new BonusNumber(input, winningTicket);
        });
    }

    @DisplayName("보너스 번호 생성 성공")
    @ParameterizedTest(name = "[1, 2, 3, 4, 5, 6]: \"{0}\"")
    @ValueSource(strings = {"7", "8", "45"})
    void createBonusNumber(String input) {
        assertThat(new BonusNumber(input, winningTicket).toString()).isEqualTo(input);
    }

}
