package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.exception.TicketRangeException;
import lotto.exception.TicketSizeException;

class TicketTest {
	private static final Ticket WINNING_NUMBER_TICKET = Ticket.create(Arrays.asList(1, 2, 3, 4, 5, 6));

	@DisplayName("Ticket 생성시 " + Ticket.SIZE_OF_LOTTO_TICKET + "개가 아니면 예외를 던진다.")
	@Test
	void createSizeMismatch() {
		// given
		List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);

		// when then
		assertThatExceptionOfType(TicketSizeException.class)
			.isThrownBy(() -> Ticket.create(values));
	}

	@DisplayName("Ticket 생성시 숫자는 지정된 범위 숫자가 아닐 경우 예외를 던진다.")
	@Test
	void createRangeMismatch() {
		// given
		List<Integer> values = Arrays.asList(Ticket.MIN_OF_LOTTO_NUMBERS - 1, Ticket.MAX_OF_LOTTO_NUMBERS + 1,
			1, 2, 3, 4);

		// when then
		assertThatExceptionOfType(TicketRangeException.class)
			.isThrownBy(() -> Ticket.create(values));
	}

	@DisplayName("Ticket 생성시 중복된 숫자가 있을 경우 예외를 던진다.")
	@Test
	void createDuplicatedValue() {
		// given
		List<Integer> values = Arrays.asList(1, 1, 1, 1, 1, 1);

		// when then
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Ticket.create(values));
	}

	@DisplayName("당첨 티켓과 번호를 비교하여 일치하는 숫자 갯수를 반환한다.")
	@ParameterizedTest(name = "{index}. ticket : {0}, matchedCount : {1}")
	@MethodSource("provideTicketWithMatchedCount")
	void from(Ticket ticket, int matchedCount) {
		// when
		int result = ticket.getMatchedCount(WINNING_NUMBER_TICKET);

		// then
		assertThat(result).isEqualTo(matchedCount);
	}

	private static Stream<Arguments> provideTicketWithMatchedCount() {
		return Stream.of(
			arguments(Ticket.create(Arrays.asList(1, 2, 3, 4, 5, 6)), 6),
			arguments(Ticket.create(Arrays.asList(1, 2, 3, 4, 5, 45)), 5),
			arguments(Ticket.create(Arrays.asList(1, 2, 3, 4, 44, 45)), 4),
			arguments(Ticket.create(Arrays.asList(1, 2, 3, 43, 44, 45)), 3),
			arguments(Ticket.create(Arrays.asList(1, 2, 42, 43, 44, 45)), 2),
			arguments(Ticket.create(Arrays.asList(1, 41, 42, 43, 44, 45)), 1),
			arguments(Ticket.create(Arrays.asList(40, 41, 42, 43, 44, 45)), 0)
		);
	}
}
