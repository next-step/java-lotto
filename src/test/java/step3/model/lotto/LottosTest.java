package step3.model.lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

	@DisplayName("주어진 개수만큼 로또를 생성한다.")
	@Test
	void Given_Count_Then_GenerateLottos() {
		int count = 3;
		Lottos lottos = new Lottos(count);

		assertThat(lottos).hasSize(count);
	}
}