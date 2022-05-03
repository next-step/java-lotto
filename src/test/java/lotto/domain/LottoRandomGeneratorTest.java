package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoRandomGeneratorTest {

	@DisplayName("로또번호 랜덤생성이 요청한 크기만큼 생성")
	@ValueSource(ints = {2, 6, 8})
	@ParameterizedTest
	public void when_GivenLottoSize_Expected_GenerateLotto(int size) {
		assertThat(LottoRandomGenerator.generate(size).size())
			.isEqualTo(size);
	}
}
