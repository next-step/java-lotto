package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottosTest {

	@Test
	void lottos_발급_테스트() {
		Lottos lottos1 = new Lottos(new Money(10999));
		Assertions.assertThat(lottos1.count()).isEqualTo(10);
		Lottos lottos2 = new Lottos(new Money(254846));
		Assertions.assertThat(lottos2.count()).isEqualTo(254);
	}

	@Test
	void lottos_발급_실패_테스트() {
		Assertions.assertThatThrownBy(() -> new Lottos(new Money(999)))
			.isInstanceOf(RuntimeException.class);
	}
}
