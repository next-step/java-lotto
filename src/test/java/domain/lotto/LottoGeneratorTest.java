package domain.lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

	@Test
	void 로또생성기로_번호_6개를_생성한다() {
		LottoGenerator lottoGenerator = new LottoGenerator();
		Lotto lotto = lottoGenerator.generate();

		assertThat(lotto.getNumbers()).hasSize(6);
	}
}
