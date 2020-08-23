package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import lotto.factory.LottoFactory;

public class LottoCreatorTest {

	@Test
	public void numberCreateTest() {
		Lotto lotto = LottoFactory.create();

		assertThat(lotto).isNotNull();
	}
}
