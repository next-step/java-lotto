package step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step2.domain.Lotto;

public class LottoIssuerTest {

	@DisplayName("로또 1장 발급")
	@Test
	void given_lotto_when_size_then_return_six() {
		Lotto lotto = new Lotto();
		assertThat(lotto.getNumbers().size()).isEqualTo(6);
	}

}
