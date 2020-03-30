package lotto.domain;

import lotto.dto.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachinePassiveTest {
	@Test
	@DisplayName("맞게 뽑아주는지 확인")
	void ticketingLottoNumberTest() {
		LottoMachinePassive lottoMachinePassive = new LottoMachinePassive();
		assertThat(
				lottoMachinePassive.ticketingLottoNumber(
						Collections.singletonList(new LottoNumbers(
								Arrays.asList(1, 2, 3, 4, 5, 6)))))
				.anyMatch(lottoNumber -> lottoNumber.getLottoNumbers().getNumbers().equals(Arrays.asList(1, 2, 3, 4, 5, 6)))
				.hasSize(1);
	}

	@Test
	@DisplayName("에러 확인")
	void ticketingExceptionTest() {
		LottoMachinePassive lottoMachinePassive = new LottoMachinePassive();
		assertThatThrownBy(() -> {
			lottoMachinePassive.ticketingLottoNumber(
					Collections.singletonList(new LottoNumbers(
							Arrays.asList(1, 2, 3, 4, 5, 5))));
		})
				.isInstanceOf(RuntimeException.class);
	}
}