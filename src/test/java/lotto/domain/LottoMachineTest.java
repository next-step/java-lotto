package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoMachineTest {

	@DisplayName("로또 개수만큼 로또 티켓 생성 테스트")
	@Test
	void generate() {
		// given
		int count = 10;
		LottoMachine lottoMachine = new LottoMachine();

		// when
		List<LottoTicket> lottoTickets = lottoMachine.generate(count);

		// then
		assertThat(lottoTickets.size()).isEqualTo(count);
	}

	@Test
	void manual() {
		// given
		LottoMachine lottoMachine = new LottoMachine();
		LottoTicket lottoTicket1 = new LottoTicket(new HashSet<>(
			Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5),
				LottoNumber.of(6))));
		LottoTicket lottoTicket2 = new LottoTicket(new HashSet<>(
			Arrays.asList(LottoNumber.of(11), LottoNumber.of(12), LottoNumber.of(13), LottoNumber.of(14),
				LottoNumber.of(15),
				LottoNumber.of(16))));
		List<String> numberStrings = Arrays.asList("1,2,3,4,5,6", "11,12,13,14,15,16");

		// when
		Collection<LottoTicket> lottoTickets = lottoMachine.manual(numberStrings);

		// then
		assertThat(lottoTickets).containsExactly(lottoTicket1, lottoTicket2);
	}
}
