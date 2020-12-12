package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {
	private List<Integer> numbers;
	@Test
	@DisplayName("로또 번호는 6개의 숫자여야 한다")
	void generatedLottoNumberSizeTest() {
		assertThatThrownBy(() -> new LottoNumber(Arrays.asList(1, 2, 3, 4, 5))).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("로또 번호는 1에서 45사이의 숫자여야 한다")
	void generatedLottoNumberRangeTest() {
		assertThatThrownBy(() -> new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 60))).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("생성된 로또 번호는 오름차순으로 정렬되어야한다")
	void generatedLottoNumberSortTest() {
		assertThatThrownBy(() -> new LottoNumber(Arrays.asList(3, 2, 1, 4, 5))).isInstanceOf(IllegalArgumentException.class);
	}
}
