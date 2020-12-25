package edu.nextstep.lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.nextstep.lotto.domain.sub.Lottos;

@DisplayName("LottosFactory: 수동으로 구매한 로또 번호와 구매 금액을 전달하면 수동 + 자동으로 구매한 로또를 반환하는 팩토리 클래스")
class LottosFactoryTest {

	@DisplayName("LottosFactory: 수동으로 구매한 로또 번호와 구매 금액을 전달하면 수동 + 자동으로 구매한 로또 목록이 반환됨")
	@Test
	void createPurchasedLottos() {
		Money money = new Money(2000);
		List<List<Integer>> manualLottoNumbersList = new ArrayList<>();
		manualLottoNumbersList.add(Arrays.asList(1, 2, 3, 6, 5, 4));
		manualLottoNumbersList.add(Arrays.asList(7, 8, 9, 12, 11, 10));

		Lottos lottos = LottosFactory.createPurchasedLottos(money, manualLottoNumbersList);

		assertThat(lottos.toList()).hasSize(4);
		assertThat(lottos.toList().get(0)).containsSequence(1, 2, 3, 6, 5, 4);
		assertThat(lottos.toList().get(1)).containsSequence(7, 8, 9, 12, 11, 10);
	}
}