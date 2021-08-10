package lottomanual.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberShuffleTest {

	@Test
	@DisplayName("로또 번호 6개 생성")
	void lotto_numbers_generate() throws Exception {
		//given

		//when
		Set<LottoNumber> numbers = LottoNumberShuffle.generate();

		//then
		assertThat(numbers).hasSize(6);

	}

	@Test
	@DisplayName("로또 번호 6개 중복 확인")
	void lotto_numbers_overlap() throws Exception {
		//given

		//when
		Set<LottoNumber> numbers = LottoNumberShuffle.generate();

		//then
		assertThat(numbers).hasSize(6);
	}

}
