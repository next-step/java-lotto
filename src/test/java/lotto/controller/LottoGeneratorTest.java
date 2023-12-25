package lotto.controller;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Digit;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoGeneratorTest {
	@DisplayName("로또 번호 6개 생성.")
	@Test
	void 로또_번호_6개_생성() {
		assertThat(LottoGenerator.generate(1).get(0)
			.indexOfLottos(0).isBetween(new Digit(1), new Digit(45))).isTrue();
	}
}
