package lottoautomatic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

	@Test
	@DisplayName("로또는 6개의 번호를 가진다.")
	void lotto_has_6_numbers() throws Exception {
		//given
		Lotto lotto = new Lotto();

		//when
		List<Integer> numbers = lotto.numbers();

		//then
		assertThat(numbers).hasSize(6);
	}

}
