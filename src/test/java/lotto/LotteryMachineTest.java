package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.domain.ListOfLottoNumbers;
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

	@DisplayName("구매 금액 n*1000원과 수동 로또 숫자가 주어지면 n개의 로또 객체를 발행해야 한다.")
	@Test
	void Should_Issue_Auto_Lotto_Substracted_Manual_Lotto_Count_When_Receive_Money_And_Manual_Lotto_Numbers() {
		LotteryMachine lotteryMachine = new LotteryMachine();
		Money money = new Money(10_000);
		ListOfLottoNumbers listOfLottoNumbers = ListOfLottoNumbers.of(
			List.of(List.of(1, 2, 3, 4, 5, 6), List.of(10, 15, 20, 25, 30, 35))
		);

		Lottos lottos = lotteryMachine.issue(money, listOfLottoNumbers);
		int expected = money.getValue() / Lotto.PRICE - listOfLottoNumbers.getListOfNumbers().size();

		assertThat(lottos.getCount()).isEqualTo(expected);
	}
}
