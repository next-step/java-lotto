package step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {
	@Test
	void create() {
		Lotto lotto = new Lotto();
		assertThat(lotto.getBalls().size()).isEqualTo(45);
	}

	@Test
	@DisplayName("자동 추첨 결과")
	void makeResult() {
		Lotto lotto = new Lotto();
		assertThat(lotto.getRandomLotto(39).size()).isEqualTo(6);
	}
}
