package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

	private final LottoMachine lottoMachine = new LottoMachine();

	@DisplayName("로또 발급 기계는 무작위로 6개의 번호를 뽑는다.")
	@Test
	void pickSixRandomNumber() {
		List<Integer> numbers = lottoMachine.pickRandomNumbers();
		assertThat(numbers).hasSize(6);
	}

	@DisplayName("로또 구입 금액을 입력하면 로또 발급 기계는 구입 금액에 해당하는 로또를 발급한다.")
	@Test
	void issueLottoTickets() {
		int price = 10_000;
		List<LottoTicket> lottoTickets = lottoMachine.issueLottoTickets(price);
		assertThat(lottoTickets).hasSize(10);
	}

}
