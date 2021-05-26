package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LottosTest {

	@Test
	void lottos_발급_테스트() {
		Lottos lottos1 = new Lottos(new Money(10999));
		assertThat(lottos1.count()).isEqualTo(10);
		Lottos lottos2 = new Lottos(new Money(254846));
		assertThat(lottos2.count()).isEqualTo(254);
	}

	@Test
	void lottos_발급_실패_테스트() {
		assertThatThrownBy(() -> new Lottos(new Money(999)))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	void lottos_밸류값_불변_테스트() {
		Lottos lottos = new Lottos(new Money(5000));
		assertThatThrownBy(() -> lottos.values().add(new Lotto()))
			.isInstanceOf(UnsupportedOperationException.class);
		assertThatThrownBy(() -> lottos.values().remove(0))
			.isInstanceOf(UnsupportedOperationException.class);
	}
}
