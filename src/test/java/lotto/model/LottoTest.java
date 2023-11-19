package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

	@Test
	@DisplayName("로또 1장당 1000원에 구매한다")
	void lotto_buy() {
		Lotto lotto = new Lotto("10000", new RandomGenerator(), new LottoResult(0, 0));

		assertThat(lotto.numberOfLotto()).isEqualTo(10);
	}

}
