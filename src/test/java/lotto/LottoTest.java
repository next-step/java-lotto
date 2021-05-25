package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class LottoTest {

	@Test
	void lotto_생성_성공() {
		List<Number> numbers = InputView.stringToNumbers("1,2,3,4,5,6");

		assertDoesNotThrow(() -> new Lotto(numbers));
	}

	@Test
	void lotto_생성_실패() {
		List<Number> numbers = InputView.stringToNumbers("1,2,3,4,5");

		assertThrows(RuntimeException.class, () -> new Lotto(numbers)); // 숫자가 5개

		numbers.add(new Number(1));
		assertThrows(RuntimeException.class, () -> new Lotto(numbers)); // 기존과 동일한 숫자 추가

		numbers.add(new Number(45));
		assertThrows(RuntimeException.class, () -> new Lotto(numbers)); // distinct 숫자 갯수는 6이나, 숫자는 7
	}

	@Test
	void lotto_매치_카운트_비교() {
		List<Number> numbers1 = InputView.stringToNumbers("1,2,3,4,5,6");
		List<Number> numbers2 = InputView.stringToNumbers("5,6,7,8,9,10");

		Lotto lotto1 = new Lotto(numbers1);

		assertThat(lotto1.matchCount(numbers1)).isEqualTo(6);
		assertThat(lotto1.matchCount(numbers2)).isEqualTo(2);
	}
}
