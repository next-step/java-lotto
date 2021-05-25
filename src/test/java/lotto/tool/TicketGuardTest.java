package lotto.tool;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.exceptions.DuplicateNumbersException;
import lotto.exceptions.EmptyNumbersException;
import lotto.exceptions.InsufficientNumbersException;
import lotto.exceptions.NumberOutOfBoundsException;

public class TicketGuardTest {

    @DisplayName("숫자 리스트는 오름차순으로 반환한다.")
    @Test
    void guard() {
        assertThat(TicketGuard.guard(Arrays.asList(6, 5, 4, 3, 2, 1)))
            .isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("숫자 리스트가 null이면 에러 발생")
    @Test
    void guard_Null_ExceptionThrown() {
        assertThatExceptionOfType(EmptyNumbersException.class).isThrownBy(() -> {
            TicketGuard.guard(null);
        });
    }

    @DisplayName("숫자 리스트가 크기가 0이면 에러 발생")
    @Test
    void guard_Empty_ExceptionThrown() {
        assertThatExceptionOfType(EmptyNumbersException.class).isThrownBy(() -> {
            TicketGuard.guard(Collections.emptyList());
        });
    }

    @DisplayName("숫자 리스트 크기가 6이 아이면 에러 발생")
    @Test
    void guard_InsufficientSize_ExceptionThrown() {
        assertThatExceptionOfType(InsufficientNumbersException.class).isThrownBy(() -> {
            TicketGuard.guard(Arrays.asList(1, 2, 3, 4, 5));
        });
        assertThatExceptionOfType(InsufficientNumbersException.class).isThrownBy(() -> {
            TicketGuard.guard(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        });
    }

    @DisplayName("숫자 범위가 1 ~ 45 사이가 아니면 에러 발생")
    @Test
    void guard_OutOfBounds_ExceptionThrown() {
        assertThatExceptionOfType(NumberOutOfBoundsException.class).isThrownBy(() -> {
            TicketGuard.guard(Arrays.asList(0, 2, 3, 4, 5, 6));
        });
        assertThatExceptionOfType(NumberOutOfBoundsException.class).isThrownBy(() -> {
            TicketGuard.guard(Arrays.asList(1, 2, 3, 4, 5, 46));
        });
    }

    @DisplayName("중복 숫자가 있으면 에러 발생")
    @Test
    void guard_Duplicate_ExceptionThrown() {
        assertThatExceptionOfType(DuplicateNumbersException.class).isThrownBy(() -> {
            TicketGuard.guard(Arrays.asList(1, 1, 1, 1, 1, 1));
        });
    }

}
