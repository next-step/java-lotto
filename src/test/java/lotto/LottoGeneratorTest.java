package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

	@Test
	public void generateLottoTest() {
		Lotto lotto = LottoGenerator.generate();
		assertThat(lotto).isNotNull();

	}
}
