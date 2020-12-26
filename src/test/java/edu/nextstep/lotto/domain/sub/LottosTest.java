package edu.nextstep.lotto.domain.sub;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
			.isInstanceOf(Lottos.class);
	}

	@DisplayName("getResultAsCountingMap: 1,3,4,5등이 각각 몇 개 씩 당첨되었는지 취합하여 map으로 리턴함.")
	@Test
	void getResultAsCountingMap() {
		Lottos lottos = new Lottos(Arrays.asList(
			// 1등.
			Arrays.asList(1, 2, 3, 4, 5, 6),
			Arrays.asList(1, 2, 3, 4, 5, 6),
			Arrays.asList(1, 2, 3, 4, 5, 6),

			// 2등.
			Arrays.asList(1, 2, 3, 4, 5, 7),
			Arrays.asList(1, 2, 3, 4, 5, 7),
			Arrays.asList(1, 2, 3, 4, 5, 7),

			// 3등.
			Arrays.asList(1, 2, 3, 4, 5, 8),
			Arrays.asList(1, 2, 3, 4, 5, 8),
			Arrays.asList(1, 2, 3, 4, 5, 8),

			// 4등.
			Arrays.asList(1, 2, 3, 4, 7, 8),
			Arrays.asList(1, 2, 3, 4, 7, 8),
			Arrays.asList(1, 2, 3, 4, 7, 8),
			Arrays.asList(1, 2, 3, 4, 7, 8),
			Arrays.asList(1, 2, 3, 4, 7, 8),

			// 5등.
			Arrays.asList(1, 2, 3, 7, 8, 9),

			// 미당첨
			Arrays.asList(1, 2, 7, 8, 9, 10)
		));
		List<Integer> winningLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

		assertThat(lottos.getResultAsCountingMap(new WinningLotto(winningLottoNumbers, 7)))
			.extractingByKeys(
				LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD,
				LottoRank.FOURTH, LottoRank.FIFTH, LottoRank.NONE)
			.containsExactly(
				3L, 3L, 3L,
				5L, 1L, 1L);
	}

	@DisplayName("toList: 일급컬랙션 내부 로또들의 숫자들을 원시값 목록 그대로 리턴함")
	@Test
	void toList() {
		Lottos lottos = new Lottos(Arrays.asList(
			Arrays.asList(1, 2, 3, 6, 5, 4),
			Arrays.asList(7, 8, 9, 12, 11, 10)
		));
		assertThat(lottos.toList()).hasSize(2);
		assertThat(lottos.toList().get(0)).containsSequence(1, 2, 3, 6, 5, 4);
		assertThat(lottos.toList().get(1)).containsSequence(7, 8, 9, 12, 11, 10);
	}
}