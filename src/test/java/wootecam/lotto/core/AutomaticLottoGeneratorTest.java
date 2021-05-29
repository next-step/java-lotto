package wootecam.lotto.core;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import wootecam.lotto.model.Lotto;

public class AutomaticLottoGeneratorTest {

	@Test
	@DisplayName("랜덤 숫자 반환 테스트")
	void test랜덤테스트() {

		AutomaticLottoGenerator autoLottoGenerator = new AutomaticLottoGenerator();
		Lotto lotto = autoLottoGenerator.getLotto();

		assertThat(lotto).isNotNull();
	}

}
