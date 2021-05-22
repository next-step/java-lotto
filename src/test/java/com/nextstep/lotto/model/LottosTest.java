package com.nextstep.lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottosTest {

	@DisplayName("구입한 로또 개수만큼 로또가 저장되어있는지 테스트")
	@ParameterizedTest
	@ValueSource(ints = {1,3,5,6})
	void 구입한_로또개수만큼_로또가_저장되는지_테스트(int lottoCount) {
		Lottos lottos = new Lottos(lottoCount);
		assertThat(lottos.getLottos().size()).isEqualTo(lottoCount);
	}
}
