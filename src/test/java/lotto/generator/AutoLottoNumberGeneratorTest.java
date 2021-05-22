package lotto.generator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.LottoNumbers;

public class AutoLottoNumberGeneratorTest {

	@Test
	@DisplayName(value = "로또 번호 생성기가 만들어주는 번호의 개수는 6개이다")
	void generateLottoNum() {
		Generator autoLottoNumberGenerator = new AutoLottoNumberGenerator();
		LottoNumbers lottoNumbers = new LottoNumbers();
		autoLottoNumberGenerator.generate(lottoNumbers);
		assertThat(lottoNumbers.isComplete()).isTrue();
	}
}
