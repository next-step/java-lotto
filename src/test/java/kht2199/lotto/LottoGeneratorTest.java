package kht2199.lotto;

import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author heetaek.kim
 */
class LottoGeneratorTest {

	LottoGenerator generator = new LottoGenerator();

	@DisplayName("로또 번호 생성")
	void random() {
		// check for no exception.
		generator.random();
	}
}