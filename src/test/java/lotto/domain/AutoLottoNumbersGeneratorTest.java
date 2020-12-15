package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AutoLottoNumbersGeneratorTest {

	@Test
	@DisplayName("N개를 입력받으면, N개의 로또를 생성해야한다.")
	void createLottoNumbersByMoneyTest() {
		assertThat(LottoNumbersGenerator.generate(5).getLottoNumbersSize()).isEqualTo(5);
	}
}
