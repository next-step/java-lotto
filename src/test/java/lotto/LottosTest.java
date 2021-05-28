package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

	@Test
	@DisplayName("구입한 로또 갯수 확인")
	void lottos_발급_테스트() {
		Lottos lottos1 = new Wallet(10999).buyAll();
		assertThat(lottos1.count()).isEqualTo(10);
		Lottos lottos2 = new Wallet(254846).buyAll();
		assertThat(lottos2.count()).isEqualTo(254);
	}

	@Test
	@DisplayName("돈이 부족할 경우 예외 발생")
	void lottos_발급_실패_테스트() {
		assertThatThrownBy(() -> new Wallet(999).buyAll())
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("로또스의 밸류값이 불변인지 확인")
	void lottos_밸류값_불변_테스트() {
		Lottos lottos = new Wallet(5000).buyAll();
		assertThatThrownBy(() -> lottos.values().add(LottoGenerator.randomNumbers()))
			.isInstanceOf(UnsupportedOperationException.class);
		assertThatThrownBy(() -> lottos.values().remove(0))
			.isInstanceOf(UnsupportedOperationException.class);
	}

	@Test
	@DisplayName("0개의 로또 입력 불가처리")
	void doesNotAllowEmptyList() {
		assertThatThrownBy(() -> new Lottos(Collections.emptyList()))
			.isInstanceOf(EmptyLottoListException.class);
	}
}
