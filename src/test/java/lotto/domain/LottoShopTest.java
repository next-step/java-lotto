package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoShopTest {
	@Test
	@DisplayName("금액을 입력하면 해당 금액에서 가능한 로또만큼 발행")
	public void buy_lottos_within_budget_limit() {
		Lottos boughtLottos = LottoShop.buy(14000);
		assertThat(boughtLottos.size()).isEqualTo(14);

		boughtLottos = LottoShop.buy(14700);
		assertThat(boughtLottos.size()).isEqualTo(14);
	}

	@Test
	@DisplayName("발행할 수 없는 금액이 입력되면 에러를 발생")
	public void buy_lottos_over_budget_limit() {
		assertThatThrownBy(() -> LottoShop.buy(0))
			.isInstanceOf(RuntimeException.class);

		assertThatThrownBy(() -> LottoShop.buy(700))
			.isInstanceOf(RuntimeException.class);

	}

	@Test
	@DisplayName("금액을 입력하고 수동 로또를 입력하면 수동 로또 발행 및 남은 금액만큼 자동 로또 발행")
	public void buy_lottos_with_manual_and_automatic() {
		List<Lotto> manualLottos = new ArrayList<>();
		manualLottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
		manualLottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));

		Lottos boughtLottos = LottoShop.buy(5000, manualLottos);

		assertThat(boughtLottos.size()).isEqualTo(5);
	}

	@Test
	@DisplayName("예산을 넘어가는 수동 로또 번호를 받으면 에러 발생")
	public void buy_lottos_over_budget_limit_with_manual_and_automatic() {
		List<Lotto> manualLottos = new ArrayList<>();
		manualLottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
		manualLottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));

		assertThatThrownBy(() -> LottoShop.buy(1000, manualLottos));
	}
}
