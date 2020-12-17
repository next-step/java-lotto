package edu.nextstep.lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.nextstep.lotto.domain.sub.Lotto;
import edu.nextstep.lotto.domain.sub.LottoRank;
import edu.nextstep.lotto.domain.sub.Lottos;

@DisplayName("Lottos: Lotto 목록의 일급 콜렉션 클래스")
class LottosTest {
	@DisplayName("생성자: 숫자를 파라미터로 받아 Lottos 객체를 정상적으로 생성하여 리턴함")
	@Test
	void generate() {
		Lottos lottos = new Lottos(Arrays.asList(
			Arrays.asList(1, 2, 3, 4, 5, 6),
			Arrays.asList(1, 2, 3, 4, 5, 6)
		));

		assertThat(lottos)
			.isNotNull()
			.isInstanceOf(Lottos.class)
			.hasNoNullFieldsOrPropertiesExcept("lottos");
	}

	@DisplayName("getResultAsCountingMap: 1,3,4,5등이 각각 몇 개 씩 당첨되었는지 취합하여 map으로 리턴함.")
	@Test
	void getResultAsCountingMap() {
		Lottos lottos = new Lottos(Arrays.asList(
			// 1등.
			Arrays.asList(1, 2, 3, 4, 5, 6),
			Arrays.asList(1, 2, 3, 4, 5, 6),
			Arrays.asList(1, 2, 3, 4, 5, 6),

			// 3등.
			Arrays.asList(1, 2, 3, 4, 5, 7),
			Arrays.asList(1, 2, 3, 4, 5, 7),
			Arrays.asList(1, 2, 3, 4, 5, 7),

			// 4등.
			Arrays.asList(1, 2, 3, 4, 7, 8),
			Arrays.asList(1, 2, 3, 4, 7, 8),
			Arrays.asList(1, 2, 3, 4, 7, 8),
			Arrays.asList(1, 2, 3, 4, 7, 8),
			Arrays.asList(1, 2, 3, 4, 7, 8),

			// 5등.
			Arrays.asList(1, 2, 3, 7, 8, 9),

			Arrays.asList(1, 2, 7, 8, 9, 10)
		));
		Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

		assertThat(lottos.getResultAsCountingMap(winningLotto))
			.extractingByKeys(LottoRank.FIRST, LottoRank.THIRD, LottoRank.FOURTH, LottoRank.FIFTH)
			.containsExactly(3L, 3L, 5L, 1L);
	}
}