package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {
	@Test
	@DisplayName("금액을 입력하면 해당 금액에서 가능한 로또만큼 발행")
	public void buy_lottos_within_budget_limit() {
		LottoGenerator lottoGenerator = new LottoGenerator();

		Lottos boughtLottos = lottoGenerator.buy(14000);
		assertThat(boughtLottos.size()).isEqualTo(14);

		boughtLottos = lottoGenerator.buy(14700);
		assertThat(boughtLottos.size()).isEqualTo(14);
	}

	@Test
	@DisplayName("발행할 수 없는 금액이 입력되면 에러를 발생")
	public void buy_lottos_over_budget_limit() {
		LottoGenerator lottoGenerator = new LottoGenerator();

		assertThatThrownBy(() -> lottoGenerator.buy(0))
			.isInstanceOf(RuntimeException.class);

		assertThatThrownBy(() -> lottoGenerator.buy(700))
			.isInstanceOf(RuntimeException.class);

	}
}
