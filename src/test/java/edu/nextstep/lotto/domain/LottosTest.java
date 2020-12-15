package edu.nextstep.lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

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
			.isInstanceOf(Lottos.class)
			.hasNoNullFieldsOrPropertiesExcept("lottos");
	}
}