package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

	@DisplayName("로또 발급 기계는 무작위로 6개의 번호를 뽑는다.")
	@Test
	void pickSixRandomNumber() {
		LottoMachine lottoMachine = new LottoMachine();
		List<Integer> numbers = lottoMachine.pickRandomNumbers();
		assertThat(numbers).hasSize(6);
	}

}
