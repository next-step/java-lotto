package lottoautomatic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {

	@Test
	@DisplayName("로또 번호 6개 생성")
	void lotto_numbers_generate() throws Exception {
		//given
		LottoNumberGenerator generator = new LottoNumberGenerator();

		//when
		List<Integer> numbers = generator.generate();

		//then
		assertThat(numbers).hasSize(6);

	}

	@Test
	@DisplayName("로또 번호 6개 중복 확인")
	void lotto_numbers_overlap() throws Exception {
		//given
		LottoNumberGenerator generator = new LottoNumberGenerator();

		//when
		List<Integer> numbers = generator.generate();
		Set<Integer> overlaps = new HashSet<>(numbers);

		//then
		assertThat(overlaps).hasSize(numbers.size());
	}

}
