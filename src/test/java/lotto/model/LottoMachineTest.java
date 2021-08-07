package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

	@Test
	@DisplayName("생성된 랜덤한 숫자는 6개이다.")
	public void randomSizeCheck() {
		Lotto result1 = LottoMachine.createLottoNumbers();

		assertThat(result1.getLottoNumbers().size()).isEqualTo(6);

		Lotto result2 = LottoMachine.createLottoNumbers();

		assertThat(result2.getLottoNumbers().size()).isEqualTo(6);
	}

}