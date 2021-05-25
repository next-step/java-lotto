package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

	@DisplayName("로또는 6개의 번호를 가진다.")
	@Test
	void LottoHasSixNumber() {
		List<LottoNumber> numbers = IntStream.range(1,5)
			.mapToObj(LottoNumber::new).collect(Collectors.toList());

		assertThatThrownBy(() -> new Lotto(numbers))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("중복된 숫자가 포함되어 있습니다.");
	}
}
