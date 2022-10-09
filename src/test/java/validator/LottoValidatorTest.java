package validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoValidatorTest {

    @Test
    @DisplayName("로또 티켓 유효성 검증")
    void validateTicketForm() {
        assertThat(LottoValidator.validateTicketForm(new TreeSet<Integer>(Arrays.asList(4, 11, 17, 28, 31, 43)))).isTrue();
        assertThat(LottoValidator.validateTicketForm(new TreeSet<Integer>(Arrays.asList(46, 47, 48, 49, 999, 1000)))).isFalse();
        assertThat(LottoValidator.validateTicketForm(new TreeSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)))).isFalse();
    }

    @Test
    @DisplayName("로또 티켓 목록 유효성 검증")
    void validateTicketForms() {
        List<NavigableSet<Integer>> invalidTickets = new ArrayList<>();
        invalidTickets.add(new TreeSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        invalidTickets.add(new TreeSet<Integer>(Arrays.asList(4, 11, 17, 28, 31, 43)));

        assertThat(LottoValidator.validateTicketForm(invalidTickets)).isFalse();
    }

    @Test
    @DisplayName("로또 티켓 목록 예외 검증")
    void validateTicketFormsException() {
        assertThatThrownBy(() -> LottoValidator.validateTicketForm(new ArrayList<>())).isInstanceOf(IllegalArgumentException.class);
    }
}
