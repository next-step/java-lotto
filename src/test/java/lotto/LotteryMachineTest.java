package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LotteryMachineTest {

	@DisplayName("n*1000원으로 발행을 요청하면 n개의 로또 객체를 발행해야 한다.")
	@ParameterizedTest
	@ValueSource(ints = {1000, 2000, 3000, 4000})
	void Should_Issue_N_Lotto_When_Receive_N000Won(int value) {
		LotteryMachine lotteryMachine = new LotteryMachine();
		Money money = new Money(value);

		List<Lotto> lottos = lotteryMachine.issue(money);
		int expected = value / Lotto.PRICE;

		assertThat(lottos.size()).isEqualTo(expected);
	}

}
