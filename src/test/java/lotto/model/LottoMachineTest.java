package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

	@Test
	@DisplayName("생성된 랜덤한 숫자는 6개이다.")
	public void randomSizeCheck() {
		List<LottoNumber> result1 = LottoMachine.createLottoNumbers().getLottoBalls();

		assertThat(result1.size()).isEqualTo(6);

		List<LottoNumber> result2 = LottoMachine.createLottoNumbers().getLottoBalls();

		assertThat(result2.size()).isEqualTo(6);
	}

}