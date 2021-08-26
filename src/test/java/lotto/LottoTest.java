package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {
	@Test
	@DisplayName("로또는 6개의 숫자로 구성됨")
	void scope() {
		assertThatThrownBy(() -> {
			Lotto numbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
		}).isExactlyInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() -> {
			Lotto numbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5));
		}).isExactlyInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("로또는 중복된 숫자를 가질 수 없음")
	void overlap() {
		assertThatThrownBy(() -> {
			Lotto numbers = new Lotto(Arrays.asList(1, 2, 3, 3, 4, 5));
		}).isExactlyInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("동일한 숫자에 몇개 있는지를 통해서 로또 결과 확인")
	void compare() {
		Lotto numbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		Lotto numbers2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
		Lotto numbers3 = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));

		assertThat(numbers.matchedCount(numbers2)).isEqualTo(5);

		assertThat(numbers.matchedCount(numbers3)).isEqualTo(0);
	}
}
