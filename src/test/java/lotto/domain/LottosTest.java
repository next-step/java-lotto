package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public final class LottosTest {
	@DisplayName("당첨 번호를 포함하는지 비교해서 포함하는 개수를 반환한다.")
	@Test
	void 당첨번호를_포함하는지_비교해서_개수를_반환한다() {
		int[] winningNumbers = {1, 2, 3, 4, 5, 7};
		List<Lotto> lottoList = Arrays.asList(new Lotto(1), new Lotto(2),
			new Lotto(3), new Lotto(4), new Lotto(5), new Lotto(6));
		Lottos lottos = new Lottos(lottoList);

		assertThat(lottos.contains(winningNumbers)).isEqualTo(5);
	}

	@DisplayName("로또 번호 6개 생성.")
	@Test
	void 로또_번호_6개_생성() {
		assertThat(Lottos.generate().get(0).isBetween(1, 45)).isTrue();
	}
}
