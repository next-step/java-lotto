package lotto.controller;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.LottoStore;

class LottoControllerTest {

	@Test
	@DisplayName("로또 구매 갯수 만큼 로또 생성")
	void crateLottos(){
		int purchaseAmount = 14000;
		LottoStore buyingLotto = new LottoStore(purchaseAmount);
		assertThat(buyingLotto.buyLotto().size()).isEqualTo(14);
	}

}