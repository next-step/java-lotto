package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineAutoTest {

	@Test
	@DisplayName("갯수 맞게 뽑아주는지 확인")
	void ticketingLottoNumberTest() {
		LottoMachineAuto lottoMachineAuto = new LottoMachineAuto();
		assertThat(lottoMachineAuto.ticketingLottoNumber(14))
				.hasSize(14);
	}
}