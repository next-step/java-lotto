package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.LottoResult;

public class LottoResultTest {
	@DisplayName("숫자 맞춤 카운팅 개수로 결과를 제대로 생성하는지 학인한다.")
	@Test
	void createTest() {
		LottoResult result = LottoResult.of(5);

		assertThat(result).isEqualTo(LottoResult.SECOND);
	}

}
