package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoAutoTest {
	private Lotto lotto;

	@BeforeEach
	void init() {
		lotto = new Lotto();
	}

	@DisplayName(value = "구입 금액에 해당하는 로또 개수를 발급하는지 테스트")
	@CsvSource(value = {"14900,14", "10000,10", "5000,5", "0,0"})
	@ParameterizedTest
	void createLotto(int amount, int expect) {
		Lottos lottos = new Lottos(amount);
		List<Lotto> lottoList = lottos.getLottos();
		int numberOfLotto = lottoList.size();
		assertThat(numberOfLotto).isEqualTo(expect);
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
