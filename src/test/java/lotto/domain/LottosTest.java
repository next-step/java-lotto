package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {
	@DisplayName("로또를 생성한다.")
	@Test
	void 로또를_생성한다() {
		Lottos lottos = new Lottos();
		List<Lotto> shuffledLottos = lottos.allLottoNumbers().shuffle();
		List<Lotto> extractedLottos = new ArrayList<>(6);
		for (int i = 0; i < 6; i++) {
			extractedLottos.add(shuffledLottos.get(i));
		}
		assertThat(extractedLottos.get(0).isBetween(new Digit(1), new Digit(45))).isTrue();
	}
}
