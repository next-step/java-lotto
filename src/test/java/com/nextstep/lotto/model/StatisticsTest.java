package com.nextstep.lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StatisticsTest {

	@DisplayName("생성한 로또 개수와 같은 결과 개수의 결과를 반환하는지 테스트")
	@ParameterizedTest
	@ValueSource(ints = {3, 4, 5})
	void 생성한_로또만큼_결과를_반환하는지_테스트(int lottoCount) {
		WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6");
		Lottos lottos = new Lottos(lottoCount);
		Statistics statistics = new Statistics(winningLotto, lottos);

		assertThat(statistics.getLottoResult().size()).isEqualTo(lottoCount);
	}
}
