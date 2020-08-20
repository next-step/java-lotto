package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import lotto.factory.LottoNumbersFactory;

public class LottoNumbersCreatorTest {

	@Test
	public void numberCreateTest() {
		LottoNumbers lottoNumbers = LottoNumbersFactory.create();

		assertThat(lottoNumbers).isNotNull();
	}
}
