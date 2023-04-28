package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

	@DisplayName("당첨넘버와 선택한 로또 넘버 간 일치하는 넘버가 몇개인지 계산한다.")
	@Test
	void test1() {
		Lotto lotto = new Lotto(Arrays.asList(1, 3, 5, 14, 22, 45));
		assertThat(lotto.calculateScore(Arrays.asList(1, 2, 3, 4, 5, 6))).isEqualTo(new Score(3));
	}
}

