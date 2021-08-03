package lottoautomatic.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberShuffleTest {

	@Test
	@DisplayName("로또 번호 6개 생성")
	void lotto_numbers_generate() throws Exception {
		//given
		LottoNumberShuffle generator = new LottoNumberShuffle();

		//when
		Set<LottoNumber> numbers = generator.generate();

		//then
		assertThat(numbers).hasSize(6);

	}

	@Test
	@DisplayName("로또 번호 6개 중복 확인")
	void lotto_numbers_overlap() throws Exception {
		//given
		LottoNumberShuffle generator = new LottoNumberShuffle();

		//when
		Set<LottoNumber> numbers = generator.generate();

		//then
		assertThat(numbers).hasSize(6);
	}

}
