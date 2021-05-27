package lotto.model;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumbersInputStrategyTest {

	@Test
	@DisplayName("숫자 입력으로 로또 숫자를 여러개를 만들어 낼 수 있다.")
	public void generateTest() {
		LottoNumbersGenerateStrategy generateStrategy = new NumbersInputStrategy(asList(
			asList(1, 2, 3, 4, 5, 6),
			asList(2, 3, 4, 5, 6, 7)
		));

		List<LottoNumbers> lottoTicket = generateStrategy.generate();

		assertThat(lottoTicket).containsExactly(LottoNumbers.of(1, 2, 3, 4, 5, 6), LottoNumbers.of(2, 3, 4, 5, 6, 7));
	}
}
