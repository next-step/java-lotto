package lotto;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

	@Test
	@DisplayName("구입한 로또 갯수 확인")
	void lottos_발급_테스트() {
		Lottos lottos1 = new Wallet(10999).buyAutoAll();
		assertThat(lottos1.count()).isEqualTo(10);
		Lottos lottos2 = new Wallet(254846).buyAutoAll();
		assertThat(lottos2.count()).isEqualTo(254);
	}

	@Test
	@DisplayName("돈이 부족할 경우 예외 발생")
	void lottos_발급_실패_테스트() {
		assertThatThrownBy(() -> new Wallet(999).buyAutoAll())
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("로또스의 밸류값이 불변인지 확인")
	void lottos_밸류값_불변_테스트() {
		Lottos lottos = new Wallet(5000).buyAutoAll();
		assertThatThrownBy(() -> lottos.values().add(LottoGenerator.generate()))
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

	@Test
	@DisplayName("두 개의 로또스가 합쳐지는지 확인")
	void mergeLottos() {
		Lotto lotto1 = LottoGenerator.generate("1,2,3,4,5,6");
		Lotto lotto2 = LottoGenerator.generate("4,5,6,7,8,9");
		Lotto lotto3 = LottoGenerator.generate("1,2,3,11,12,13");
		Lotto lotto4 = LottoGenerator.generate("1,9,17,25,33,41");

		Lottos lottos1 = new Lottos(new ArrayList<>(asList(lotto1, lotto2)));
		Lottos lottos2 = new Lottos(new ArrayList<>(asList(lotto3, lotto4)));

		assertThat(lottos1.mergeWith(lottos2))
			.isEqualTo(new Lottos(new ArrayList<>(asList(lotto1, lotto2, lotto3, lotto4))));
	}
}
