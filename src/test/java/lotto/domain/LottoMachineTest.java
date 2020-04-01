package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

	@Test
	@DisplayName("갯수 맞게 뽑아주는지 확인")
	void ticketingLottoNumberTest() {
		LottoMachine lottoMachineAuto = new LottoMachine();
		assertThat(lottoMachineAuto.autoTicketingLottoNumber(14))
				.hasSize(14);
	}

	@Test
	@DisplayName("로또 번호 전부 다 같은 번호 나오지는 않는지 확인 테스트")
	void LottoDistinctionTest() {
		LottoMachine lottoMachineAuto = new LottoMachine();

		assertThat(lottoMachineAuto.autoTicketingLottoNumber(5)
				.stream()
				.distinct())
				.hasSize(5);
	}
}