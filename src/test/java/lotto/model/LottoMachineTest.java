package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

	@Test
	@DisplayName("생성된 랜덤한 숫자는 6개이다.")
	public void randomSizeCheck() {
		List<Integer> result1 = LottoMachine.createLottoNumbers().getLottoBalls();

		assertThat(result1.size()).isEqualTo(6);

		List<Integer> result2 = LottoMachine.createLottoNumbers().getLottoBalls();

		assertThat(result2.size()).isEqualTo(6);
	}

	@Test
	@DisplayName("생성된 랜덤한 숫자는 0보다 크고 46보다 작다.")
	public void numberRangeCheck() {
		List<Integer> result1 = LottoMachine.createLottoNumbers().getLottoBalls();
		result1.forEach(attribute -> assertThat(attribute).isGreaterThan(0).isLessThan(46));

		List<Integer> result2 = LottoMachine.createLottoNumbers().getLottoBalls();
		result2.forEach(attribute -> assertThat(attribute).isGreaterThan(0).isLessThan(46));
	}

}