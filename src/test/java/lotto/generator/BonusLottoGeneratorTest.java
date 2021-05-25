package lotto.generator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.BonusLotto;

class BonusLottoGeneratorTest {

	@Test
	@DisplayName(value = "bonusGame generator 는 LottoNumbers 의 하위 객체를 생성한다")
	void instanceOf() {
		BonusLottoGenerator generator = new BonusLottoGenerator("1, 2, 3, 4, 5, 6", 7);
		assertThat(generator.generate()).isInstanceOf(BonusLotto.class);
	}

}