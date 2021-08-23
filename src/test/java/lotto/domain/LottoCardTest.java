package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCardTest {

	@DisplayName(value = "로또 카드의 1 ~ 45 번호가 생성되는지 테스트")
	@Test
	void lottoCardNumbers() {
		List<Integer> numbers = LottoCard.NUMBERS;

		List<Integer> expect = new ArrayList<>();
		for (int i = 1; i <= 45; i++) {
			expect.add(i);
		}

		assertThat(numbers).containsAll(expect);
	}
}