package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

	@DisplayName(value = "로또 번호가 1부터 45까지 각각 다른 6개의 번호로 구성되는지 테스트")
	@Test
	void numbersOfLotto() {
		LottoCard lottoCard = LottoCard.getInstance();
		Lotto lotto = lottoCard.issue();

		List<Integer> numbers = lotto.getNumbers()
			.stream()
			.map(Number::getValue)
			.distinct()
			.collect(Collectors.toList());
		int numberOfDistinctNumbers = numbers.size();
		assertThat(numberOfDistinctNumbers).isEqualTo(6);

		List<Integer> lottoCardNumbers = LottoCard.NUMBERS;
		assertThat(lottoCardNumbers).containsAll(numbers);
	}
}