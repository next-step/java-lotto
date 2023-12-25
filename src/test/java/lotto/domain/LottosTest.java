package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {
	@DisplayName("랜덤 번호가 1~45의 숫자인지 확인.")
	@Test
	void 랜덤_번호가_1부터45까지의_숫자인지_확인() {
		Lottos lottos = new Lottos();
		List<Lotto> shuffledLottos = lottos.allLottoNumbers().shuffle();
		assertThat(shuffledLottos.get(0).isBetween(new Digit(1), new Digit(45))).isTrue();
	}
}
