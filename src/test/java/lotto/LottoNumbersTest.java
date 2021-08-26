package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumbersTest {

	List<LottoNumber> createNumbers(List<Integer> numbers) {
		return numbers.stream().map(number -> new LottoNumber(number)).collect(Collectors.toList());
	}

	@Test
	@DisplayName("로또는 6개의 숫자로 구성됨")
	void scope() {
		assertThatThrownBy(() -> {
			LottoNumbers numbers = new LottoNumbers(createNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
		}).isExactlyInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() -> {
			LottoNumbers numbers = new LottoNumbers(createNumbers(Arrays.asList(1, 2, 3, 4, 5)));
		}).isExactlyInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("로또는 중복된 숫자를 가질 수 없음")
	void overlap() {
		assertThatThrownBy(() -> {
			LottoNumbers numbers = new LottoNumbers(createNumbers(Arrays.asList(1, 2, 3, 3, 4, 5)));
		}).isExactlyInstanceOf(IllegalArgumentException.class);
	}
}
