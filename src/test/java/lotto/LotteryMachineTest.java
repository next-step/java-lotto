package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.domain.LotteryMachine;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;

class LotteryMachineTest {

	@DisplayName("n*1000원으로 발행을 요청하면 n개의 로또 객체를 발행해야 한다.")
	@ParameterizedTest
	@ValueSource(ints = {1000, 2000, 3000, 4000})
	void Should_Issue_N_Lotto_When_Receive_N000Won(int value) {
		LotteryMachine lotteryMachine = new LotteryMachine();
		Money money = new Money(value);

		Lottos lottos = lotteryMachine.issue(money);
		int expected = value / Lotto.PRICE;

		assertThat(lottos.getCount()).isEqualTo(expected);
	}

}
