package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRunnerTest {

	@Test
	@DisplayName("N,000원을 전달하면 생성될 로또번호의 수는 N개 여야한다.")
	void winningResultCountTest() {
		assertThat(LottoRunner.lottoTotalAmount(5000)).isEqualTo(5);
	}
}
