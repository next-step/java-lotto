package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {
	private Lotto lotto;

	@BeforeEach
	void init() {
		LottoCard lottoCard = LottoCard.getInstance();
		lotto = lottoCard.issue();
	}

	@DisplayName(value = "로또 번호가 1부터 45까지 각각 다른 6개의 번호로 구성되는지 테스트")
	@Test
	void numbersOfLotto() {
		List<Integer> numbers = lotto.getNumbers()
			.stream()
			.distinct()
			.collect(Collectors.toList());
		int numberOfDistinctNumbers = numbers.size();
		assertThat(numberOfDistinctNumbers).isEqualTo(6);

		List<Integer> lottoCard = LottoCard.NUMBERS;
		assertThat(lottoCard).containsAll(numbers);
	}
}
