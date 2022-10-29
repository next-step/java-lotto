package step2.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

	@Test
	void randomGeneratingTest(){
		LottoGenerator randomLottoGenerator = RandomLottoGenerator.init();
		assertThat(randomLottoGenerator.generating().size()).isEqualTo(6);
	}
}