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


	@Test
	@DisplayName("로또 번호 6개 오름차순")
	void lotto_numbers_sort() throws Exception {
		//given
		LottoNumberGenerator generator = new LottoNumberGenerator();

		//when
		List<Integer> numbers = generator.generate();

		//then
		assertThat(numbers.get(0)).isLessThan(numbers.get(1));
		assertThat(numbers.get(1)).isLessThan(numbers.get(2));
		assertThat(numbers.get(2)).isLessThan(numbers.get(3));
		assertThat(numbers.get(3)).isLessThan(numbers.get(4));
		assertThat(numbers.get(4)).isLessThan(numbers.get(5));
	}

}
