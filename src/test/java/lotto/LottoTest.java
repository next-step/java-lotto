package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

	@Test
	@DisplayName("6개의 숫자를 가짐")
	void scope() {
		assertThatThrownBy(() -> {
			new Lotto(Arrays.asList(1, 2, 3, 4, 5));
		}).isExactlyInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("같은 숫자 갯수")
	void match() {
		Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		Lotto lotto2 = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));

		assertThat(lotto1.matchNumber(lotto1)).isEqualTo(6);

		assertThat(lotto1.matchNumber(lotto2)).isEqualTo(0);
	}

	@Test
	@DisplayName("숫자를 포함 확인")
	void contains() {
		Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

		assertThat(lotto.contains(new LottoNumber(1))).isTrue();

		assertThat(lotto.contains(new LottoNumber(7))).isFalse();
	}
}
