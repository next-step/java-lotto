package domain.lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LottosTest {

	@Test
	void 금액만큼_로또를_구입한다() {
		Lottos lottos = new Lottos(14000);
		assertThat(lottos.getLottos()).hasSize(14);
	}
}
