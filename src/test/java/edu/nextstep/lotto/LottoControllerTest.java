package edu.nextstep.lotto;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LottoController: MVC 패턴 기반의, view와 domain을 엮는 controller 역할")
class LottoControllerTest {

	@DisplayName("getRandomLottoNumbersList: random함수로부터 지정된 개수만큼의 1 ~ 45사이의 중복없는 6개의 로또 번호들을 리턴함.")
	@Test
	void getRandomLottoNumbersList() {
		assertThat(new LottoController().getRandomLottoNumbersList(5))
			.hasSize(5)
			.allSatisfy(numbers ->
				assertThat(numbers)
					.hasSize(6)
					.hasSameSizeAs(Sets.newHashSet(numbers)) // 중복 없음 체크
					.allMatch(num -> num > 0 && num < 46)
			);
	}
}