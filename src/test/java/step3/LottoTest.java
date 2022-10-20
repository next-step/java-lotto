package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {
	@Test
	void create() {
		LottoFactory lotto = new LottoFactory();
		assertThat(lotto.getBalls().size()).isEqualTo(45);
	}

	@Test
	@DisplayName("자동 추첨 결과")
	void makeResult() {
		LottoFactory lotto = new LottoFactory();
		assertThat(lotto.getRandomLotto().size()).isEqualTo(6);
	}
}
