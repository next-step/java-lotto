package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoMachineTest {

	@DisplayName("구매한 만큼의 로또를 생성한다.")
	@Test
	void test1() {
		assertThat(new LottoMachine(14000).lottosSize()).isEqualTo(14);
	}

	@DisplayName("구매한 만큼의 로또를 생성한다. - 예외 케이스")
	@ValueSource(ints = {800, 1400})
	@ParameterizedTest
	void test2(int buyAmount) {
		assertThatIllegalArgumentException().isThrownBy(() -> new LottoMachine(buyAmount));
	}

	@DisplayName("총 수익을 계산한다.")
	@Test
	void test3() {
		List<Lotto> lottos = Arrays.asList(new Lotto(3), new Lotto(6));
		LottoMachine lottoMachine = new LottoMachine(lottos);
		int totalProfit = lottoMachine.totalProfit();
		assertThat(totalProfit).isEqualTo(2000005000);
	}

	@DisplayName("총 수익률을 계산한다.")
	@Test
	void test4() {
		LottoMachine lottoMachine = new LottoMachine(14000);
		assertThat(lottoMachine.totalProfitRate(5000, 14000)).isEqualTo(0.35);
	}
}
