package lotto.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;

public class LottoGeneratorTest {

	@Test
	@DisplayName("자동 로또 생성 테스트")
	public void generateLottoTest() {
		Lotto lotto = LottoGenerator.generate();
		assertThat(lotto).isNotNull();
	}
}
