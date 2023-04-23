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
		assertThat(new LottoMachine(14000).purchasedLottosSize()).isEqualTo(14);
	}

	@DisplayName("구매한 만큼의 로또를 생성한다. - 예외 케이스")
	@ValueSource(ints = {800, 1400})
	@ParameterizedTest
	void test2(int purchaseAmount) {
		assertThatIllegalArgumentException().isThrownBy(() -> new LottoMachine(purchaseAmount));
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
		LottoMachine lottoMachine = new LottoMachine();
		assertThat(lottoMachine.totalProfitRate(5000, 14000)).isEqualTo(0.35);
	}

	@DisplayName("손익 여부를 계산한다. - 이득인 케이스")
	@Test
	void test5() {
		LottoMachine lottoMachine = new LottoMachine();
		assertThat(lottoMachine.isBenefit(1.01)).isTrue();
	}

	@DisplayName("손익 여부를 계산한다. - 손해인 케이스")
	@Test
	void test6() {
		LottoMachine lottoMachine = new LottoMachine();
		assertThat(lottoMachine.isBenefit(0.99)).isFalse();
	}
}
