package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoMachineTest {

	private final LottoMachine lottoMachine = new LottoMachine();

	@DisplayName("로또 발급 기계는 무작위로 6개의 번호를 뽑는다.")
	@Test
	void pickSixRandomNumber() {
		List<Integer> numbers = lottoMachine.pickRandomNumbers();
		assertThat(numbers).hasSize(6).doesNotHaveDuplicates();
	}

	@DisplayName("로또 구입 금액을 입력하면 로또 발급 기계는 구입 금액에 해당하는 로또를 발급한다.")
	@CsvSource(value = {"10000,10", "5500,5"})
	@ParameterizedTest
	void issueLottoTickets(int money, int numberOfLottoTickets) {
		LottoTickets lottoTickets = lottoMachine.issueLottoTickets(money);
		assertThat(lottoTickets.getTickets()).hasSize(numberOfLottoTickets);
	}

}
