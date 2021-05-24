package lotto.model;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SupplierGenerateStrategyTest {

	@Test
	@DisplayName("로또 숫자를 정해진 숫자 대로 여러개 생성할 수 있다.")
	public void generateTest() {
		LottoNumbersGenerateStrategy generateStrategy = new SupplierGenerateStrategy(() -> asList(1, 2, 3, 4, 5, 6));

		List<LottoNumbers> lottoTicket = generateStrategy.generate(2);

		assertThat(lottoTicket).containsExactly(LottoNumbers.of(1, 2, 3, 4, 5, 6), LottoNumbers.of(1, 2, 3, 4, 5, 6));
	}
}
