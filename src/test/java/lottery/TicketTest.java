package lottery;

import static org.assertj.core.api.Assertions.*;

import java.util.LinkedHashSet;
import java.util.Set;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.Test;

import lottery.exceptions.InvalidTicketSizeException;

class TicketTest {

	Ticket sut;

	@Test
	void create() {
		LottoNumbers lottoNumbers = LottoNumbers.from(Sets.newLinkedHashSet(1, 2, 3, 4, 5, 6));

		sut = Ticket.of(lottoNumbers);

		Set<Integer> values = sut.numbers().getValues();
		assertThat(values).hasSize(6);
		assertThat(values).containsAll(lottoNumbers.getValues());

		assertThatThrownBy(() -> Ticket.of(LottoNumbers.from(new LinkedHashSet<>())))
			.isInstanceOf(InvalidTicketSizeException.class);
	}
}
